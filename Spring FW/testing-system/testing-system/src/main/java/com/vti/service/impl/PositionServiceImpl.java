package com.vti.service.impl;

import com.vti.DTO.PositionDTO;
import com.vti.entity.Position;
import com.vti.enumerate.PositionName;
import com.vti.form.PositionCreateForm;
import com.vti.form.PositionUpdateForm;
import com.vti.repository.IPositionRepository;
import com.vti.service.IPositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;
    @Autowired
    private ModelMapper modelMapper;

    //DTO
    @Override
    public List<PositionDTO> findAll() {
        List<Position> positions = positionRepository.findAll();
        List<PositionDTO> dtos = new ArrayList<>();


        for (Position pos : positions) {
            PositionDTO dto = modelMapper.map(pos, PositionDTO.class);
            dtos.add(dto);
        }
        return dtos;
    }
    // DTO
    @Override
    public PositionDTO findById(Integer id) {
        Position position = positionRepository.findById(id).orElse(null);
        if (position == null) {
            return null;
        }
        return modelMapper.map(position, PositionDTO.class);
    }
    @Override
    public Position findByName(String name) {
        PositionName positionName = convertStringToEnum(name);
        if (positionName != null) {
            return positionRepository.findByPositionName(positionName).orElse(null);
        }
        return null;
    }

    @Override
    public Position create(String name) {
        PositionName positionName = convertStringToEnum(name);
        if (positionName == null) {
            throw new IllegalArgumentException("Chức vụ không hợp lệ! Chỉ chấp nhận: Dev, Test, Scrum Master, PM");
        }

        Position position = new Position();
        position.setPositionName(positionName);
        return positionRepository.save(position);
    }

    @Override
    public Position update(Integer id, String newName) {
        if (positionRepository.existsById(id)) {
            PositionName positionName = convertStringToEnum(newName);
            if (positionName == null) {
                throw new IllegalArgumentException("Chức vụ mới không hợp lệ!");
            }

            Position position = new Position();
            position.setPositionId(id);
            position.setPositionName(positionName);
            return positionRepository.save(position);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
            return true;
        }
        return false;
    }
// Dùng form
    @Override
    public void create(PositionCreateForm form) {
        Position position = new Position();
        // Nhớ check xem biến trong Entity Position của bạn tên là positionName hay name nhé
        position.setPositionName(PositionName.valueOf(form.getName()));
        positionRepository.save(position);
    }

    @Override
    public void update(Integer id, PositionUpdateForm form) {
        Position position = positionRepository.findById(id).orElse(null);
        if (Objects.isNull(position)) {
            throw new RuntimeException("Position ID not found!");
        }
        position.setPositionName(PositionName.valueOf(form.getName()));
        positionRepository.save(position);
    }

    // Hàm Chuyển đổi từ chuỗi chữ thường gặp sang Enum
    private PositionName convertStringToEnum(String name) {
        for (PositionName enumValue : PositionName.values()) {
            if (enumValue.getValue().equalsIgnoreCase(name)) {
                return enumValue;
            }
        }
        return null; // Trả về null nếu chuỗi không khớp với 4 chức vụ
    }
}
