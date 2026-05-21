package backend.service;

import entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAllAccounts();
    List<Account> findByName(String name);
    boolean insertAccount(String email, String username, String fullName, int departmentId, int positionId);
    boolean updateAccount(int id, String fullName);
    public  boolean deleteAccount(int id) ;

    String importAccountToCSV(String pathName);
}
