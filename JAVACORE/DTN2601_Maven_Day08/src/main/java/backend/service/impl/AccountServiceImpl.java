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
import entity.Account;

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
            System.out.println(
                    "Username đã tồn tại"
            );
            return false;
        }

        // FULLNAME


        // null
        if (fullName == null) {

            System.out.println(
                    "Họ tên không được null"
            );

            return false;
        }

        // empty
        if (fullName.trim().isEmpty()) {

            System.out.println(
                    "Họ tên không được để trống"
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

        // =====================================================
        // POSITION ID
        // =====================================================

        if (!positionRepository.existsById(
                positionId
        )) {

            System.out.println(
                    "Chức vụ không tồn tại"
            );

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
}
