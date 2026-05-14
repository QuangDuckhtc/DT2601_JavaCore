package backend.controller;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import entity.Department;

import java.util.List;

public class DepartmentController {
    IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    public List<Department> findByDepartmentIDAndName(int searchId, String searchName) {
        return departmentRepository.findByDepartmentIDAndName(searchId,searchName);
    }


    public boolean insertDepartment(String newName) {
        return departmentRepository.insertDepartment(newName);
    }


    public boolean deleteDepartment(int deleteId) {
        return departmentRepository.deleteDepartment(deleteId);
    }


    public boolean updateDepartment(int id, String updateName) {
        return departmentRepository.updateDepartment(id, updateName);
    }


    public List<Department> getDepartmentHasMostEmployee() {
        return departmentRepository.getDepartmentHasMostEmployee();
    }


    public List<Department> getDepartmentHasLeastEmployee() {
        return departmentRepository.getDepartmentHasLeastEmployee();
    }
}
