package backend.controller;

import backend.repository.IAccountRepository;
import backend.repository.impl.AccountRepositoryImpl;
import entity.Account;

import java.util.List;

public class AccountController {
    IAccountRepository accountRepository = new AccountRepositoryImpl();

    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }


    public List<Account> findByName(String name) {
        return accountRepository.findByName(name);
    }


    public boolean insertAccount(String email, String username, String fullName, int departmentId, int positionId) {
        return accountRepository.insertAccount(email,username,fullName,departmentId,positionId);
    }


    public boolean updateAccount(int id, String fullName) {
        return accountRepository.updateAccount(id,fullName);
    }


    public boolean deleteAccount(String name) {
        return accountRepository.deleteAccount(name);
    }
}
