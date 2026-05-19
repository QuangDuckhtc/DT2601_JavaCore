package backend.repository;

import entity.Account;

import java.util.List;

public interface IAccountRepository {
    List<Account> getAllAccounts();
    List<Account> findByName(String name);
    boolean insertAccount(String email, String username, String fullName, int departmentId, int positionId);
    boolean updateAccount(int id, String userName);
    public  boolean deleteAccount(int id) ;

//    check
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsById(int id);

    boolean updateUsername(int id, String newUsername);

    boolean existsByUsernameForUpdate(String username, int id);
}
