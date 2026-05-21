package backend.repository;

import entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface IDepartmentRepository {
    List<Department> getAllDepartments();
    List<Department> findByDepartmentIDAndName(int searchId, String searchName);
    boolean insertDepartment(String newName);
    boolean deleteDepartment(int deleteId);
    boolean updateDepartment(int id, String updateName);
    List<Department> getDepartmentHasMostEmployee();
    List<Department> getDepartmentHasLeastEmployee();
//check --> valication
    boolean existsByName(String name);
    boolean existsById(int id);
    boolean existsByNameForUpdate(String name, int id);
// thêm nhiều department

    boolean createDepartments (List<Department> departments) throws SQLException;

    Department findById(int deptId);
}
