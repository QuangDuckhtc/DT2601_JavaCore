package com.vti.controller;

import com.vti.DTO.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentSearchForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    // phan trang , lọc
    @GetMapping
    public ResponseEntity<Page<DepartmentDTO>> findAll(@PageableDefault(page = 0, size = 10) Pageable pageable, DepartmentSearchForm form) {

        Page<DepartmentDTO> departments = departmentService.findAll(pageable, form);

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
    // 2. Tìm theo ID: GET http://localhost:8080/api/departments/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        DepartmentDTO dto = departmentService.findById(id);
        if (dto == null) {
            return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

//    // 3. Thêm mới
//    // POST http://localhost:8080/api/departments?name=Phòng Marketing
//    @PostMapping
//    public ResponseEntity<Department> create(@RequestParam String name) {
//        Department createdDept = departmentService.create(name);
//        return new ResponseEntity<>(createdDept, HttpStatus.CREATED);
//    }

    // 4. Cập nhật
    // PUT http://localhost:8080/api/departments/1?newName=Phòng Kế Toán Nâng Cấp
//    @PutMapping("/{id}")
//    public ResponseEntity<Department> update(@PathVariable Integer id, @RequestParam String newName) {
//        Department updatedDept = departmentService.update(id, newName);
//        if (updatedDept != null) {
//            return new ResponseEntity<>(updatedDept, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    // 5. Xóa: DELETE http://localhost:8080/api/departments/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            departmentService.delete(id);
            return new ResponseEntity<>("Delete department successfully", HttpStatus.OK);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            return new ResponseEntity<>("Không thể xóa phòng ban này vì đang có nhân viên thuộc phòng!", HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
// DUNG FORM CHO CREATE VA UPDATE
    //  Create
    @PostMapping
    public ResponseEntity<?> create(@RequestBody DepartmentCreateForm form) {
        departmentService.create(form);
        return new ResponseEntity<>("Create successfully", HttpStatus.CREATED);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DepartmentUpdateForm form) {
        try {
            departmentService.update(id, form);
            return new ResponseEntity<>("Update successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
