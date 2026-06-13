package com.vti.service.impl;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired // Khởi tạo tự động đối tượng Repository
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> findByName(String name) {
        return departmentRepository.findByNameContaining(name);
    }

    @Override
    public Department findById(Integer id) {
        Optional<Department> optional = departmentRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Department create(String name) {
        Department dept = new Department();
        dept.setName(name);
        return departmentRepository.save(dept); // Lưu mới (id tự tăng)
    }

    @Override
    public Department update(Integer id, String newName) {
        Optional<Department> optionalDept = departmentRepository.findById(id);
        if (optionalDept.isPresent()) {
            Department dept = optionalDept.get();
            dept.setName(newName);
            return departmentRepository.save(dept); // Lưu cập nhật (vì đã có id)
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}