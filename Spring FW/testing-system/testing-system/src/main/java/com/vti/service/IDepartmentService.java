package com.vti.service;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll(); // Lấy tất cả
    List<Department> findByName(String name); // Tìm theo tên
    Department findById(Integer id); // Tìm theo ID
    Department create(String name); // Thêm mới
    Department update(Integer id, String newName); // Cập nhật
    boolean delete(Integer id); // Xóa
}
