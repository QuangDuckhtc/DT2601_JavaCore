package backend.service;

import entity.Department;

import java.io.FileNotFoundException;
import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments();
    List<Department> findByDepartmentIDAndName(int searchId, String searchName);
    boolean insertDepartment(String newName);
    boolean deleteDepartment(int deleteId);
    boolean updateDepartment(int id, String updateName);
    List<Department> getDepartmentHasMostEmployee();
    List<Department> getDepartmentHasLeastEmployee();



    String importDepartmentToCSV(String pathName);
}
