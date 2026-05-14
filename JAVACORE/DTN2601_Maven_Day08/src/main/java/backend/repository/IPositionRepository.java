package backend.repository;

import entity.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> getAllPositions();
   List<Position> findByName(String name);
    boolean insertPosition(String name);
    boolean updatePosition(int id, String name);
    boolean deletePosition(String name);
    List<Position> getPositionHasMostEmployee();
    List<Position> getPositionHasLeastEmployee();
}
