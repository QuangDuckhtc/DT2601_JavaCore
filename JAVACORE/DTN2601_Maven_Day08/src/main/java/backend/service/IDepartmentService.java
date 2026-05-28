package backend.service;

import dto.context.DepartmentContext;
import dto.csv.DepartmentCsv;
import entity.Department;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IDepartmentService extends IImportFile<DepartmentCsv, DepartmentContext, Department> {
    List<Department> getAllDepartments();
    List<Department> findByDepartmentIDAndName(int searchId, String searchName);
    boolean insertDepartment(String newName);
    boolean deleteDepartment(int deleteId);
    boolean updateDepartment(int id, String updateName);
    List<Department> getDepartmentHasMostEmployee();
    List<Department> getDepartmentHasLeastEmployee();



    String importDepartmentToCSV(String pathName) throws SQLException;

}
