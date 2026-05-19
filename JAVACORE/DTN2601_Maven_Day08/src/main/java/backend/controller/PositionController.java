package backend.controller;

import backend.service.IPositionService;
import backend.service.impl.PositionServiceImpl;
import entity.Position;
import entity.PositionName;

import java.util.List;

public class PositionController {
     IPositionService iPositionService = new PositionServiceImpl();

    public List<Position> getAllPositions() {
        return iPositionService.getAllPositions();
    }


    public List<Position> findByName(String name) {
        return iPositionService.findByName(name);
    }


    public boolean insertPosition(PositionName positionName) {
        return iPositionService.insertPosition(positionName);
    }


    public boolean updatePosition(int id, String name) {
        return iPositionService.updatePosition(id,name);
    }


    public boolean deletePosition(int id) {
        return iPositionService.deletePosition(id);
    }


    public List<Position> getPositionHasMostEmployee() {
        return iPositionService.getPositionHasMostEmployee();
    }


    public List<Position> getPositionHasLeastEmployee() {
        return iPositionService.getPositionHasLeastEmployee();
    }
}
