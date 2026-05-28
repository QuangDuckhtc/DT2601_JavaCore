package backend.service.impl;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.service.IDepartmentService;
import dto.ImportError;
import dto.context.DepartmentContext;
import dto.csv.DepartmentCsv;
import entity.Department;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DepartmentServiceImpl implements IDepartmentService {
    IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public List<Department> findByDepartmentIDAndName(int searchId, String searchName) {
        return departmentRepository.findByDepartmentIDAndName(searchId, searchName);
    }

    @Override
    public boolean insertDepartment(String newName) {

        // null
        if (newName == null) {
            System.out.println("Tên phòng ban không được null");
            return false;
        }

        // empty
        if (newName.trim().isEmpty()) {
            System.out.println("Tên phòng ban không được để trống");
            return false;
        }

        // duplicate
        if (departmentRepository.existsByName(newName.trim())) {

            System.out.println("Tên phòng ban đã tồn tại");
            return false;
        }

        boolean result = departmentRepository.insertDepartment(newName.trim());

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

            System.out.println("ID phòng ban phải lớn hơn 0");
            return false;
        }

        // check exists
        if (!departmentRepository.existsById(id)) {

            System.out.println("Phòng ban không tồn tại");

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

        // duplicate
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

    // đọc file csv + lấy ra danh sách department để gửi xuống repository để lưu lại
    // row nào gặp lỗi xuất ra file lỗi
    // row nào lo lỗi thì import bình thường
    @Override
    public String importDepartmentToCSV(String pathName) throws SQLException {//pathName đường dẫn file trong máy
        Map<String, Department> mapDepartmentByName = departmentRepository.mapDepartmentByName();
        DepartmentContext context = new DepartmentContext(mapDepartmentByName);
        return this.importFile(pathName, context, "E:\\DT2601_JavaCore\\file csv\\output_department_error.csv");

    }

    @Override
    public List<DepartmentCsv> readFile(String pathName) {
        List<DepartmentCsv> csvs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            String line = br.readLine();// bo di hang header
            while ((line = br.readLine()) != null) {
                // logic doc file
                String[] fileds = line.split(",", -1);
                DepartmentCsv departmentCsv = new DepartmentCsv(fileds[0]);
                csvs.add(departmentCsv);
            }

        } catch (Exception e) {
        }
        return csvs;
    }

    @Override
    public void validation(DepartmentCsv departmentCsv, DepartmentContext context, List<ImportError> importErrors, List<Department> entities) {
        List<String> errors = new ArrayList<>();// luu lai ds loi cua line này
        String departmentName = departmentCsv.getName().trim().toLowerCase();

        if (Objects.isNull(departmentName) || departmentName.trim().isEmpty()) {
            errors.add("Tên phòng ban không được để trống");
        } else if (context.getMapByName().containsKey(departmentName)) {
            errors.add("Tên phòng ban đã tồn tại");
        }

        if (errors.isEmpty()) {// nếu ko có lỗi thì thêm vào ds để lưu vào DB
            Department dep = new Department(departmentName);
            entities.add(dep);
            // moi khi có department hop le thi se them luôn vào map để check trùng các row sau
            Map<String, Department> map = context.getMapByName();
            map.put(departmentName, dep);
            context.setMapByName(map);
        } else {// có lỗi thì xuất ra
            importErrors.add(new ImportError(departmentName, String.join(" | ", errors)));
        }
    }

    @Override
    public void saveAll(List<Department> entities) throws SQLException {
        departmentRepository.createDepartments(entities);
    }

    @Override
    public void exportFileError(List<ImportError> importErrors, String pathError) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathError))) {
            bw.write("depatment_name,message_error");
            bw.newLine();
            for (ImportError error : importErrors) {
                bw.write(error.getLine() + "," + error.getMessage());
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

//E:\DT2601_JavaCore\file csv\input_department.csv