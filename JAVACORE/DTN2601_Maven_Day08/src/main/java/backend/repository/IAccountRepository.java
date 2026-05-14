package backend.repository;

import entity.Account;

import java.util.List;

public interface IAccountRepository {
    List<Account> getAllAccounts();
    List<Account> findByName(String name);
    boolean insertAccount(String email, String username, String fullName, int departmentId, int positionId);
    boolean updateAccount(int id, String fullName);
    public  boolean deleteAccount(String name) ;

}
