package backend.service.impl;

import backend.repository.IPositionRepository;
import backend.repository.impl.PositionRepositoryImpl;
import backend.service.IPositionService;
import entity.Position;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    IPositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> getAllPositions() {
        return positionRepository.getAllPositions();
    }

    @Override
    public List<Position> findByName(String name) {
        return positionRepository.findByName(name);
    }

    @Override
    public boolean insertPosition(String name) {
        return positionRepository.insertPosition(name);
    }

    @Override
    public boolean updatePosition(int id, String name) {
        return positionRepository.updatePosition(id,name);
    }

    @Override
    public boolean deletePosition(String name) {
        return positionRepository.deletePosition(name);
    }

    @Override
    public List<Position> getPositionHasMostEmployee() {
        return positionRepository.getPositionHasMostEmployee();
    }

    @Override
    public List<Position> getPositionHasLeastEmployee() {
        return positionRepository.getPositionHasLeastEmployee();
    }
}
