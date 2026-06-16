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

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> findByName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department create(String name) {
        // Tự tạo Object Department mới rồi gán name vào để lưu xuống DB
        Department department = new Department();
        department.setDepartmentName(name);
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Integer id, String newName) {
        // Kiểm tra xem phòng ban cần sửa có tồn tại không
        if (departmentRepository.existsById(id)) {
            Department department = new Department();
            department.setDepartmentId(id);       // Giữ nguyên ID cũ
            department.setDepartmentName(newName); // Cập nhật tên mới
            return departmentRepository.save(department);
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