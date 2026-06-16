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

    // 1. Lấy tất cả hoặc Tìm kiếm theo tên
    // Lấy tất cả: GET http://localhost:8080/api/departments
    // Tìm theo tên: GET http://localhost:8080/api/departments?name=Phòng Giám Đốc
    @GetMapping
    public ResponseEntity<List<Department>> findAllOrSearch(@RequestParam(value = "name", required = false) String name) {
        List<Department> departments;
        if (name != null && !name.isEmpty()) {
            departments = departmentService.findByName(name);
        } else {
            departments = departmentService.findAll();
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // 2. Tìm theo ID: GET http://localhost:8080/api/departments/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Integer id) {
        Department department = departmentService.findById(id);
        if (department != null) {
            return new ResponseEntity<>(department, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 3. Thêm mới
    // POST http://localhost:8080/api/departments?name=Phòng Marketing
    @PostMapping
    public ResponseEntity<Department> create(@RequestParam String name) {
        Department createdDept = departmentService.create(name);
        return new ResponseEntity<>(createdDept, HttpStatus.CREATED);
    }

    // 4. Cập nhật
    // PUT http://localhost:8080/api/departments/1?newName=Phòng Kế Toán Nâng Cấp
    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Integer id, @RequestParam String newName) {
        Department updatedDept = departmentService.update(id, newName);
        if (updatedDept != null) {
            return new ResponseEntity<>(updatedDept, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 5. Xóa: DELETE http://localhost:8080/api/departments/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (departmentService.delete(id)) {
            return new ResponseEntity<>(" Xóa thành công !", HttpStatus.OK);
        }
        return new ResponseEntity<>("ID không tồn tại !", HttpStatus.NOT_FOUND);
    }
}
