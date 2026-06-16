package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    // Tìm kiếm gần đúng theo tên (LIKE %keyword%)
    List<Department> findByDepartmentName(String name);
}
