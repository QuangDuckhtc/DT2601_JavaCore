package backend.repository;

import entity.Account;
import entity.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    // thêm nhiều accounts
    boolean createAccounts (List<Account> accounts) throws SQLException;

    Map<String, Account> mapAccountByEmail();

    Map<String, Account> mapAccountByUsername();
}
