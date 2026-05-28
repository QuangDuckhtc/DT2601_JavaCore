package backend.service.impl;

import backend.repository.IAccountRepository;
import backend.repository.IDepartmentRepository;
import backend.repository.IPositionRepository;
import backend.repository.impl.AccountRepositoryImpl;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.repository.impl.PositionRepositoryImpl;
import backend.service.IAccountService;
import dto.ImportError;
import dto.context.AccountContext;
import dto.csv.AccountCsv;
import entity.Account;
import entity.Department;
import entity.PositionName;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AccountServiceImpl implements IAccountService {
    IAccountRepository accountRepository = new AccountRepositoryImpl();
    IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    IPositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public List<Account> findByName(String name) {
        return accountRepository.findByName(name);
    }

    @Override
    public boolean insertAccount(String email, String username, String fullName, int departmentId, int positionId) {

        // USERNAME

        //null
        if (username == null) {
            System.out.println("Username không được null");
            return false;
        }

        // empty
        if (username.trim().isEmpty()) {
            System.out.println("Username không được để trống");
            return false;
        }

        // duplicate
        if (accountRepository.existsByUsername(username.trim())) {
            System.out.println("Username đã tồn tại");
            return false;
        }

        // FULLNAME


        // null
        if (fullName == null) {

            System.out.println("Họ tên không được null");
            return false;
        }
        // empty
        if (fullName.trim().isEmpty()) {

            System.out.println("Họ tên không được để trống");
            return false;
        }
        // EMAIL
        // null
        if (email == null) {
            System.out.println("Email không được null");
            return false;
        }
        // empty
        if (email.trim().isEmpty()) {

            System.out.println("Email không được để trống");

            return false;
        }
        // regex email
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!email.matches(regex)) {
            System.out.println("Email không đúng định dạng");
            return false;
        }
        // duplicate email
        if (accountRepository.existsByEmail(email.trim())) {
            System.out.println("Email đã tồn tại");
            return false;
        }

        // DEPARTMENT ID
        if (!departmentRepository.existsById(
                departmentId
        )) {

            System.out.println(
                    "Phòng ban không tồn tại"
            );

            return false;
        }


        // POSITION ID


        if (!positionRepository.existsById(
                positionId
        )) {

            System.out.println("Chức vụ không tồn tại");
            return false;
        }


        // INSERT

        boolean result = accountRepository.insertAccount(username.trim(), fullName.trim(), email.trim(), departmentId, positionId);
        if (result) {
            System.out.println("Tạo mới account thành công");

        } else {
            System.out.println("Tạo mới account thất bại");
        }
        return result;
    }

    @Override
    public boolean updateAccount(int id, String newUsername) {

        // CHECK ID > 0


        if (id <= 0) {

            System.out.println("ID account phải lớn hơn 0");

            return false;
        }

        // CHECK ACCOUNT EXISTS
        if (!accountRepository.existsById(id)) {

            System.out.println(
                    "Account không tồn tại"
            );

            return false;
        }

        // CHECK USERNAME NULL


        if (newUsername == null) {

            System.out.println("Username không được null");

            return false;
        }


        // CHECK USERNAME EMPTY

        if (newUsername.trim().isEmpty()) {

            System.out.println(
                    "Username không được để trống"
            );

            return false;
        }

        // CHECK DUPLICATE USERNAME

        if (accountRepository.existsByUsernameForUpdate(newUsername.trim(), id)) {
            System.out.println("Username đã tồn tại");
            return false;
        }

        // UPDATE
        boolean result = accountRepository.updateUsername(id, newUsername.trim());

        if (result) {

            System.out.println("Cập nhật username thành công");

        } else {

            System.out.println("Cập nhật username thất bại");
        }
        return result;
    }

    @Override
    public boolean deleteAccount(int id) {
        if (id <= 0) {

            System.out.println("ID account phải lớn hơn 0");

            return false;
        }

        // CHECK ACCOUNT EXISTS

        if (!accountRepository.existsById(id)) {

            System.out.println("Account không tồn tại");
            return false;
        }
        // DELETE
        boolean result = accountRepository.deleteAccount(id);

        if (result) {

            System.out.println("Xóa account thành công");

        } else {
            System.out.println("Xóa account thất bại");
        }

        return result;
    }

    @Override
    public String importAccountToCSV(String pathName) throws SQLException {


        // map email từ DB
        Map<String, Account> mapByEmail = accountRepository.mapAccountByEmail();

        // map username từ DB
        Map<String, Account> mapByUsername = accountRepository.mapAccountByUsername();

        // map department
        Map<Integer, Department> mapDepartmentById = departmentRepository.mapDepartmentById();

        // context
        AccountContext context = new AccountContext(mapByEmail, mapByUsername, mapDepartmentById);
        return this.importFile(pathName, context, "E:\\DT2601_JavaCore\\file csv\\account_error.csv");
    }

    @Override
    public List readFile(String path) {

        List<AccountCsv> csvs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // bỏ header
            String line = br.readLine();

            // đọc từng dòng
            while ((line = br.readLine()) != null) {
                // bỏ dòng rỗng
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] fields = line.split(",", -1);

                AccountCsv accountCsv = new AccountCsv(
                        fields[1], // username
                        fields[2], // fullname
                        fields[0], // email
                        fields[3], // department
                        fields[4]  // position
                );

                csvs.add(accountCsv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return csvs;
    }

    @Override
    public void validation(AccountCsv accountCsv, AccountContext context, List<ImportError> importErrors, List<Account> entities) {
        List<String> errors = new ArrayList<>();

        // USERNAME

        String username = accountCsv.getUsername();

        if (Objects.isNull(username) || username.trim().isEmpty()) {
            errors.add("Username không được để trống");

        } else {
            username = username.trim().toLowerCase();

            if (context.getMapByUsername().containsKey(username)) {
                errors.add("Username đã tồn tại");
            }
        }

        //  FULLNAME

        String fullName = accountCsv.getFullName();

        if (Objects.isNull(fullName) || fullName.trim().isEmpty()) {
            errors.add("Fullname không được để trống");

        } else {
            fullName = fullName.trim();
        }

        //  EMAIL

        String email = accountCsv.getEmail();

        if (Objects.isNull(email) || email.trim().isEmpty()) {

            errors.add("Email không được để trống");

        } else {

            email = email.trim().toLowerCase();

            if (!email.contains("@")) {
                errors.add("Email không đúng định dạng");

            } else if (context.getMapByEmail().containsKey(email)) {
                errors.add("Email đã tồn tại");
            }
        }

        //  DEPARTMENT

        Department department = null;

        String departmentIdStr = accountCsv.getDepartmentID();

        try {
            int departmentId = Integer.parseInt(departmentIdStr);

            department = context.getMapDepartmentById().get(departmentId);

            if (department == null) {
                errors.add("Department không tồn tại");
            }

        } catch (Exception e) {

            errors.add("Department ID không hợp lệ");
        }

        // POSITION

        PositionName position = null;

        try {

            position = PositionName.valueOf(accountCsv.getPositionName().trim().toUpperCase());

        } catch (Exception e) {

            errors.add("Position không hợp lệ");
        }

        // VALID

        if (errors.isEmpty()) {

            Account acc = new Account();

            acc.setUsername(username);

            acc.setFullName(fullName);

            acc.setEmail(email);

            acc.setDepartment(department);

            acc.setPositionName(position);

            entities.add(acc);

            // add map check duplicate
            context.getMapByUsername().put(username, acc);

            context.getMapByEmail().put(email, acc);

        } else {

            importErrors.add(new ImportError(username, String.join(" | ", errors)));
        }
    }


    @Override
    public void saveAll(List entities) throws SQLException {
        accountRepository.createAccounts(entities);
    }

    @Override
    public void exportFileError(List<ImportError> importErrors, String pathError) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathError))) {
            // header
            bw.write("line,message_error");
            bw.newLine();

            // ghi từng dòng lỗi
            for (ImportError error : importErrors) {

                bw.write(error.getLine() + "," + error.getMessage());
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


// E:\DT2601_JavaCore\file csv\input_account.csv
