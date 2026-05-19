package backend.service.impl;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.service.IDepartmentService;
import entity.Department;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public List<Department> findByDepartmentIDAndName(int searchId, String searchName) {
        return departmentRepository.findByDepartmentIDAndName(searchId,searchName);
    }

    @Override
    public boolean insertDepartment(String newName) {

        // null
        if (newName == null) {
            System.out.println(
                    "Tên phòng ban không được null"
            );
            return false;
        }

        // empty
        if (newName.trim().isEmpty()) {

            System.out.println(
                    "Tên phòng ban không được để trống"
            );

            return false;
        }

        // duplicate
        if (departmentRepository.existsByName(newName.trim())) {

            System.out.println(
                    "Tên phòng ban đã tồn tại"
            );

            return false;
        }

        boolean result =
                departmentRepository.insertDepartment(
                        newName.trim()
                );

        if (result) {
            System.out.println("Tạo mới phòng ban thành công");

        } else {
            System.out.println("Tạo mới phòng ban thất bại");
        }

        return result;
    }

    @Override
    public boolean deleteDepartment(int deleteId) {
        // id <= 0
        if (deleteId <= 0) {

            System.out.println("ID phòng ban phải lớn hơn 0");
            return false;
        }

        // check exists
        if (!departmentRepository.existsById(deleteId)) {

        }

        boolean result = departmentRepository.deleteDepartment(deleteId);

        if (result) {
            System.out.println("Xóa phòng ban thành công");

        } else {
            System.out.println("Xóa phòng ban thất bại");
        }

        return result;
    }

    @Override
    public boolean updateDepartment(int id, String updateName) {
        // invalid id
        if (id <= 0) {

            System.out.println(
                    "ID phòng ban phải lớn hơn 0"
            );

            return false;
        }

        // check exists
        if (!departmentRepository.existsById(id)) {

            System.out.println(
                    "Phòng ban không tồn tại"
            );

            return false;
        }

        // null
        if (updateName == null) {

            System.out.println("Tên phòng ban không được null");

            return false;
        }

        // empty
        if (updateName.trim().isEmpty()) {

            System.out.println("Tên phòng ban không được để trống");
            return false;
        }

        // duplicate except itself
        if (departmentRepository.existsByNameForUpdate(updateName.trim(), id)) {

            System.out.println("Tên phòng ban đã tồn tại");

            return false;
        }

        boolean result = departmentRepository.updateDepartment(id, updateName.trim()
                );

        if (result) {

            System.out.println("Cập nhật phòng ban thành công");

        } else {

            System.out.println("Cập nhật phòng ban thất bại");
        }

        return result;
    }

    @Override
    public List<Department> getDepartmentHasMostEmployee() {
        return departmentRepository.getDepartmentHasMostEmployee();
    }

    @Override
    public List<Department> getDepartmentHasLeastEmployee() {
        return departmentRepository.getDepartmentHasLeastEmployee();
    }
}
