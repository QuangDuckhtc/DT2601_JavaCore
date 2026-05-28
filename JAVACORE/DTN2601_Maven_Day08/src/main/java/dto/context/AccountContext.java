package dto.context;

import entity.Account;
import entity.Department;

import java.util.Map;

public class AccountContext {
    private Map<String, Account> mapByEmail;

    private Map<String, Account> mapByUsername;

    private Map<Integer, Department> mapDepartmentById;

    public AccountContext(
            Map<String, Account> mapByEmail,
            Map<String, Account> mapByUsername,
            Map<Integer, Department> mapDepartmentById
    ) {

        this.mapByEmail = mapByEmail;

        this.mapByUsername = mapByUsername;

        this.mapDepartmentById = mapDepartmentById;
    }

    public Map<String, Account> getMapByEmail() {
        return mapByEmail;
    }

    public Map<String, Account> getMapByUsername() {
        return mapByUsername;
    }

    public Map<Integer, Department> getMapDepartmentById() {
        return mapDepartmentById;
    }
}
