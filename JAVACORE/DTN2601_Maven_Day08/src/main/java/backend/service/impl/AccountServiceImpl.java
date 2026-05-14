package backend.service.impl;

import backend.repository.IAccountRepository;
import backend.repository.impl.AccountRepositoryImpl;
import backend.service.IAccountService;
import entity.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    IAccountRepository accountRepository = new AccountRepositoryImpl();
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
        return accountRepository.insertAccount(email,username,fullName,departmentId,positionId);
    }

    @Override
    public boolean updateAccount(int id, String fullName) {
        return accountRepository.updateAccount(id,fullName);
    }

    @Override
    public boolean deleteAccount(String name) {
        return accountRepository.deleteAccount(name);
    }
}
