package com.vti.controller;

import com.vti.entity.Position;
import com.vti.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> findAllOrSearch(@RequestParam(value = "name", required = false) String name) {
        if (name != null && !name.isEmpty()) {
            Position position = positionService.findByName(name);
            if (position != null) {
                return new ResponseEntity<>(position, HttpStatus.OK);
            }
            return new ResponseEntity<>("Khong tim thay chuc vu: " + name, HttpStatus.NOT_FOUND);
        }

        List<Position> positions = positionService.findAll();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    // 2. Tìm theo ID: GET http://localhost:8080/api/positions/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Position> findById(@PathVariable Integer id) {
        Position position = positionService.findById(id);
        if (position != null) {
            return new ResponseEntity<>(position, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 3. Thêm mới: POST http://localhost:8080/api/positions?name=Test
    @PostMapping
    public ResponseEntity<?> create(@RequestParam String name) {
        try {
            Position createdPos = positionService.create(name);
            return new ResponseEntity<>(createdPos, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // 4. Cập nhật: PUT http://localhost:8080/api/positions/1?newName=PM
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestParam String newName) {
        try {
            Position updatedPos = positionService.update(id, newName);
            if (updatedPos != null) {
                return new ResponseEntity<>(updatedPos, HttpStatus.OK);
            }
            return new ResponseEntity<>("ID không tồn tại!", HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // 5. Xóa: DELETE http://localhost:8080/api/positions/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (positionService.delete(id)) {
            return new ResponseEntity<>("Xóa thành công !", HttpStatus.OK);
        }
        return new ResponseEntity<>("ID không tồn tại!", HttpStatus.NOT_FOUND);
    }
}