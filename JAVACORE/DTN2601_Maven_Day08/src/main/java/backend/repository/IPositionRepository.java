package backend.repository;

import entity.Department;
import entity.Position;

import java.sql.SQLException;
import java.util.List;

public interface IPositionRepository {
    List<Position> getAllPositions();
   List<Position> findByName(String name);
    boolean insertPosition(String name);
    boolean updatePosition(int id, String name);
    boolean deletePosition(int id);
    List<Position> getPositionHasMostEmployee();
    List<Position> getPositionHasLeastEmployee();
//check
    boolean existsByName(String name);
    boolean existsByNameForUpdate(String name, int id);
    boolean existsById(int id);

//

}
