package com.vti.controller;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    // Lấy tất cả hoặc tìm kiếm theo tên
    @GetMapping
    public ResponseEntity<List<Department>> findAll(@RequestParam(value = "search", required = false) String search) {
        List<Department> departments;
        if (search != null && !search.isEmpty()) {
            departments = departmentService.findByName(search);
        } else {
            departments = departmentService.findAll();
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // Lấy theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Integer id) {
        Department department = departmentService.findById(id);
        if (department != null) {
            return new ResponseEntity<>(department, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Thêm mới
    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department dept) {
        Department createdDept = departmentService.create(dept.getName());
        return new ResponseEntity<>(createdDept, HttpStatus.CREATED);
    }

    // Cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Integer id, @RequestBody Department dept) {
        Department updatedDept = departmentService.update(id, dept.getName());
        if (updatedDept != null) {
            return new ResponseEntity<>(updatedDept, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (departmentService.delete(id)) {
            return new ResponseEntity<>("Deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found ID!", HttpStatus.NOT_FOUND);
    }
}