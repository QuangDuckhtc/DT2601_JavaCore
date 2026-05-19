package backend.service.impl;

import backend.repository.IPositionRepository;
import backend.repository.impl.PositionRepositoryImpl;
import backend.service.IPositionService;
import entity.Position;
import entity.PositionName;

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
    public boolean insertPosition(PositionName positionName) {
        // null
        if (positionName == null) {

            System.out.println("Tên chức vụ không được null");

            return false;
        }

        // duplicate
        if (positionRepository.existsByName(positionName.name().toLowerCase())) {

            System.out.println("Chức vụ đã tồn tại");
            return false;
        }

        boolean result = positionRepository.insertPosition(positionName.name().toLowerCase());
        if (result) {

            System.out.println("Tạo mới chức vụ thành công");

        } else {

            System.out.println("Tạo mới chức vụ thất bại");
        }

        return result;
    }

    @Override
    public boolean updatePosition(int id, String name) {

        // id <= 0
        if (id <= 0) {

            System.out.println("ID chức vụ phải lớn hơn 0");

            return false;
        }

        // check exists id
        if (!positionRepository.existsById(id)) {

            System.out.println("Chức vụ không tồn tại");
            return false;
        }

        // null
        if (name == null) {

            System.out.println("Tên chức vụ không được null");

            return false;
        }

        // empty
        if (name.trim().isEmpty()) {

            System.out.println("Tên chức vụ không được để trống");

            return false;
        }

        // duplicate
        if (positionRepository.existsByNameForUpdate(name.trim().toLowerCase(), id)) {

            System.out.println("Chức vụ đã tồn tại");

            return false;
        }

        boolean result = positionRepository.updatePosition(id, name.trim().toLowerCase());

        if (result) {

            System.out.println("Cập nhật chức vụ thành công");

        } else {
            System.out.println("Cập nhật chức vụ thất bại");
        }

        return result;
    }

    @Override
    public boolean deletePosition(int id) {

        // id <= 0
        if (id <= 0) {

            System.out.println("ID chức vụ phải lớn hơn 0");

            return false;
        }

        // check exists
        if (!positionRepository.existsById(id)) {

            System.out.println("Chức vụ không tồn tại");
            return false;
        }

        boolean result = positionRepository.deletePosition(id);

        if (result) {
            System.out.println("Xóa chức vụ thành công");

        } else {
            System.out.println("Xóa chức vụ thất bại");
        }
        return result;
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
