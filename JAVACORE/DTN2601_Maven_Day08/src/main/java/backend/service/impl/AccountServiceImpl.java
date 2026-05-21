package backend.service.impl;

import backend.repository.IAccountRepository;
import backend.repository.IDepartmentRepository;
import backend.repository.IPositionRepository;
import backend.repository.impl.AccountRepositoryImpl;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.repository.impl.PositionRepositoryImpl;
import backend.service.IAccountService;
import backend.service.IDepartmentService;
import backend.service.IPositionService;
import dto.ImportError;
import entity.Account;
import entity.Department;
import entity.PositionName;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Username đã tồn tại");return false;
        }

        // FULLNAME


        // null
        if (fullName == null) {

            System.out.println("Họ tên không được null"
            );

            return false;
        }

        // empty
        if (fullName.trim().isEmpty()) {

            System.out.println("Họ tên không được để trống"
            );
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
    public String importAccountToCSV(String pathName) {
        List<Account> accounts = new ArrayList<>();
        List<ImportError> importErrors = new ArrayList<>();

        boolean firstLine = true;
        boolean checkImport = false;

        try {
            //  (fix lỗi copy)
            pathName = pathName.trim()
                    .replace("\u202A", "")
                    .replace("\u202C", "")
                    .replace("\u200E", "")
                    .replace("\u200F", "");

            File file = new File(pathName);
            if (!file.exists()) {
                return "File không tồn tại";
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                List<String> errors = new ArrayList<>();

                String[] fields = line.split(",");

                if (fields.length < 5) {
                    continue;
                }

                String email = fields[0];
                String username = fields[1];
                String fullName = fields[2];
                String deptIdStr = fields[3];
                String positionStr = fields[4];


                // EMAIL

                if (email == null || email.trim().isEmpty()) {
                    errors.add("Email không được để trống");
                } else if (!email.contains("@")) {
                    errors.add("Email sai định dạng");
                } else if (accountRepository.existsByEmail(email)) {
                    errors.add("Email đã tồn tại");
                }


                // USERNAME

                if (username == null || username.trim().isEmpty()) {
                    errors.add("Username không được để trống");
                } else if (accountRepository.existsByUsername(username)) {
                    errors.add("Username đã tồn tại");
                }
                // FULL NAME
                if (fullName == null || fullName.trim().isEmpty()) {
                    errors.add("Fullname không được để trống");
                }
                // DEPARTMENT
                Department dept = null;
                try {
                    int deptId = Integer.parseInt(deptIdStr);
                    dept = departmentRepository.findById(deptId);

                    if (dept == null) {
                        errors.add("Department không tồn tại");
                    }

                } catch (Exception e) {
                    errors.add("Department ID không hợp lệ");
                }
                // POSITION ENUM
                PositionName position = null;
                try {
                    position = PositionName.valueOf(positionStr.toUpperCase());
                } catch (Exception e) {
                    errors.add("Position không hợp lệ");
                }

                // ADD LIST
                if (errors.isEmpty()) {

                    Account acc = new Account();
                    acc.setEmail(email);
                    acc.setUsername(username);
                    acc.setFullName(fullName);
                    acc.setDepartment(dept);
                    acc.setPositionName(position);

                    accounts.add(acc);

                } else {

                    importErrors.add(new ImportError(line, String.join(" | ", errors))
                    );
                }
            }

            // WRITE ERROR FILE
            String errorPath = "E:\\DT2601_JavaCore\\file csv\\account_error.csv";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(errorPath))) {

                bw.write("Line ,error");
                bw.newLine();

                for (ImportError err : importErrors) {

                    bw.write(err.getLine() + "," + err.getMessage());
                    bw.newLine();
                }
            }
            // BATCH INSERT
            if (!accounts.isEmpty()) {
                checkImport = accountRepository.createAccounts(accounts);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkImport ? "Import thành công" : "Import thất bại - xem file error";
    }
}
// E:\DT2601_JavaCore\file csv\input_account.csv