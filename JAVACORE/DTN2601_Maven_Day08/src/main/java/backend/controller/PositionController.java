package backend.controller;

import backend.repository.IPositionRepository;
import backend.repository.impl.PositionRepositoryImpl;
import entity.Position;

import java.util.List;

public class PositionController {
    IPositionRepository positionRepository = new PositionRepositoryImpl();

    public List<Position> getAllPositions() {
        return positionRepository.getAllPositions();
    }


    public List<Position> findByName(String name) {
        return positionRepository.findByName(name);
    }


    public boolean insertPosition(String name) {
        return positionRepository.insertPosition(name);
    }


    public boolean updatePosition(int id, String name) {
        return positionRepository.updatePosition(id,name);
    }


    public boolean deletePosition(String name) {
        return positionRepository.deletePosition(name);
    }


    public List<Position> getPositionHasMostEmployee() {
        return positionRepository.getPositionHasMostEmployee();
    }


    public List<Position> getPositionHasLeastEmployee() {
        return positionRepository.getPositionHasLeastEmployee();
    }
}
