package com.vti.controller;

import com.vti.DTO.PositionDTO;
import com.vti.entity.Position;
import com.vti.form.PositionCreateForm;
import com.vti.form.PositionUpdateForm;
import com.vti.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    // 1. Lấy tất cả hoặc tìm kiếm theo tên:
    // GET http://localhost:8080/api/positions
    // GET http://localhost:8080/api/positions?name=Dev
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<PositionDTO> dtos = positionService.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    // 2. Tìm theo ID: GET http://localhost:8080/api/positions/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        PositionDTO dto = positionService.findById(id);
        if (dto == null) {
            return new ResponseEntity<>("Position not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // 3. Thêm mới: POST http://localhost:8080/api/positions?name=Test
//    @PostMapping
//    public ResponseEntity<?> create(@RequestParam String name) {
//        try {
//            Position createdPos = positionService.create(name);
//            return new ResponseEntity<>(createdPos, HttpStatus.CREATED);
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    // 4. Cập nhật: PUT http://localhost:8080/api/positions/1?newName=PM
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable Integer id, @RequestParam String newName) {
//        try {
//            Position updatedPos = positionService.update(id, newName);
//            if (updatedPos != null) {
//                return new ResponseEntity<>(updatedPos, HttpStatus.OK);
//            }
//            return new ResponseEntity<>("ID không tồn tại!", HttpStatus.NOT_FOUND);
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    // 5. Xóa: DELETE http://localhost:8080/api/positions/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            positionService.delete(id);
            return new ResponseEntity<>("Delete position successfully", HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            // Bắt chính xác lỗi ràng buộc Khóa ngoại
            return new ResponseEntity<>("Không thể xóa chức vụ này vì đang có nhân viên đảm nhiệm!", HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            // Bắt các lỗi không tồn tại ID thông thường
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
//Dromt
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PositionCreateForm form) {
        positionService.create(form);
        return new ResponseEntity<>("Create position successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody PositionUpdateForm form) {
        try {
            positionService.update(id, form);
            return new ResponseEntity<>("Update position successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}