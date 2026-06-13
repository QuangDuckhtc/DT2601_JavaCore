package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    // Tìm kiếm gần đúng theo tên (LIKE %keyword%)
    List<Department> findByNameContaining(String keyword);
}
