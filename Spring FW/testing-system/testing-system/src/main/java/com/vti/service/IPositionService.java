package com.vti.service;

import com.vti.entity.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();                  // Lấy tất cả chức vụ
    Position findById(Integer id);             // Tìm chức vụ theo ID
    Position findByName(String name);          // Tìm chức vụ theo chuỗi chữ thô (Ví dụ: "Dev")
    Position create(String name);              // Thêm mới chức vụ (Truyền chuỗi chữ thô)
    Position update(Integer id, String newName); // Cập nhật tên chức vụ mới
    boolean delete(Integer id);                // Xóa chức vụ
}
