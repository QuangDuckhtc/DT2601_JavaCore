package backend.service;

import entity.Position;

import java.util.List;

public interface IPositionService {
    List<Position> getAllPositions();
    List<Position> findByName(String name);
    boolean insertPosition(String name);
    boolean updatePosition(int id, String name);
    boolean deletePosition(String name);
    List<Position> getPositionHasMostEmployee();
    List<Position> getPositionHasLeastEmployee();
}
