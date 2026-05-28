package backend.controller;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.service.IDepartmentService;
import backend.service.impl.DepartmentServiceImpl;
import entity.Department;

import java.sql.SQLException;
import java.util.List;

public class DepartmentController {
    IDepartmentService iDepartmentService = new DepartmentServiceImpl();

    public List<Department> getAllDepartments() {
        return iDepartmentService.getAllDepartments();
    }

    public List<Department> findByDepartmentIDAndName(int searchId, String searchName) {
        return iDepartmentService.findByDepartmentIDAndName(searchId,searchName);
    }


    public boolean insertDepartment(String newName) {
        return iDepartmentService.insertDepartment(newName);
    }


    public boolean deleteDepartment(int deleteId) {
        return iDepartmentService.deleteDepartment(deleteId);
    }


    public boolean updateDepartment(int id, String updateName) {
        return iDepartmentService.updateDepartment(id, updateName);
    }


    public List<Department> getDepartmentHasMostEmployee() {
        return iDepartmentService.getDepartmentHasMostEmployee();
    }


    public List<Department> getDepartmentHasLeastEmployee() {
        return iDepartmentService.getDepartmentHasLeastEmployee();
    }

    public String importDepartmentToCSV(String pathName) throws SQLException {// trả về string để thong báo thành công hay thất bại
        return iDepartmentService.importDepartmentToCSV(pathName);
    }
}
