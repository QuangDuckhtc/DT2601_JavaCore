package com.vti.service;

import com.vti.DTO.PositionDTO;
import com.vti.entity.Position;
import com.vti.form.PositionCreateForm;
import com.vti.form.PositionUpdateForm;

import java.util.List;

public interface IPositionService {
    // DTO với findALL và findbyID

    List<PositionDTO> findAll();

    PositionDTO findById(Integer id);// Tìm chức vụ theo ID

    Position findByName(String name);

    Position create(String name);

    Position update(Integer id, String newName);

    boolean delete(Integer id);


// dùng form với create và update
    void create(PositionCreateForm form);
    void update(Integer id, PositionUpdateForm form);
}