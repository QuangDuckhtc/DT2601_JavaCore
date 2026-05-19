package backend.service;

import entity.Position;
import entity.PositionName;

import java.util.List;

public interface IPositionService {
    List<Position> getAllPositions();
    List<Position> findByName(String name);
    boolean insertPosition(PositionName positionName);
    boolean updatePosition(int id, String name);
    boolean deletePosition(int id );
    List<Position> getPositionHasMostEmployee();
    List<Position> getPositionHasLeastEmployee();
}
