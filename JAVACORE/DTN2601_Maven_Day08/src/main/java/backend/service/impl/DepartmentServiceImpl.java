package backend.service.impl;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.service.IDepartmentService;
import entity.Department;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public List<Department> findByDepartmentIDAndName(int searchId, String searchName) {
        return departmentRepository.findByDepartmentIDAndName(searchId,searchName);
    }

    @Override
    public boolean insertDepartment(String newName) {
        return departmentRepository.insertDepartment(newName);
    }

    @Override
    public boolean deleteDepartment(int deleteId) {
        return departmentRepository.deleteDepartment(deleteId);
    }

    @Override
    public boolean updateDepartment(int id, String updateName) {
        return departmentRepository.updateDepartment(id, updateName);
    }

    @Override
    public List<Department> getDepartmentHasMostEmployee() {
        return departmentRepository.getDepartmentHasMostEmployee();
    }

    @Override
    public List<Department> getDepartmentHasLeastEmployee() {
        return departmentRepository.getDepartmentHasLeastEmployee();
    }
}
