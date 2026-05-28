package backend.service;

import dto.ImportError;
import dto.context.AccountContext;
import dto.csv.AccountCsv;
import entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService extends IImportFile<AccountCsv, AccountContext, Account> {
    List<Account> getAllAccounts();
    List<Account> findByName(String name);
    boolean insertAccount(String email, String username, String fullName, int departmentId, int positionId);
    boolean updateAccount(int id, String fullName);
    public  boolean deleteAccount(int id) ;

    String importAccountToCSV(String pathName) throws SQLException;

}
