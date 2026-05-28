package backend.controller;

import backend.repository.IAccountRepository;
import backend.repository.impl.AccountRepositoryImpl;
import backend.service.IAccountService;
import backend.service.impl.AccountServiceImpl;
import entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountController {
    IAccountService iAccountService = new AccountServiceImpl();

    public List<Account> getAllAccounts() {
        return iAccountService.getAllAccounts();
    }


    public List<Account> findByName(String name) {
        return iAccountService.findByName(name);
    }


    public boolean insertAccount(String email, String username, String fullName, int departmentId, int positionId) {
        return iAccountService.insertAccount(email,username,fullName,departmentId,positionId);
    }


    public boolean updateAccount(int id, String userName) {
        return iAccountService.updateAccount(id, userName);
    }


    public boolean deleteAccount(int id) {
        return iAccountService.deleteAccount(id);
    }

    public String importAccountToCSV(String pathName) throws SQLException {
        return iAccountService.importAccountToCSV(pathName);
    }
}
