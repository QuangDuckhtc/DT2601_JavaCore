package com.vti.service.impl;

import com.vti.entity.Position;
import com.vti.enumerate.PositionName;
import com.vti.repository.IPositionRepository;
import com.vti.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(Integer id) {
        return positionRepository.findById(id).orElse(null);
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
