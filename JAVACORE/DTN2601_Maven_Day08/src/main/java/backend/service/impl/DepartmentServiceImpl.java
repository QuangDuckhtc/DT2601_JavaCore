package backend.service.impl;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.service.IDepartmentService;
import dto.ImportError;
import entity.Department;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
    public String importDepartmentToCSV(String pathName) {//pathName đường dẫn file trong máy
//        dùng bufferReader
//        FileReader fr = new FileReader(pathName); // đọc file từ path, đọc từng chữ cái
//        BufferedReader br = new BufferedReader((fr)); // đọc theo từng dòng

        List<Department> departments = new ArrayList<>();
        List<ImportError> importErrors = new ArrayList<>();
        boolean firstLine = true;
        boolean checkImport = false;
        String message = "";
        try (BufferedReader br = new BufferedReader((new FileReader(pathName)))) {
//            String line = br.readLine();// đang đọc 1 dòng
            List<String> errors = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
//              bỏ qua dòng đầu tiên header

                if (firstLine){
                    firstLine = false;
                    continue;
                }
                String[] fields = line.split(",");
                String departmentName = fields[0];
                // validation dữ liệu
                 if (Objects.isNull(departmentName) || departmentName.trim().isEmpty()){
                     //tên phòng ban không được trống
                        errors.add("tên phòng không được trống");
                 }
                 if ( departmentRepository.existsByName(departmentName)){
                     // ten phong ban da ton tai
                     errors.add("Tên phòng ban đã tồn tại");
                 }
                 if(errors.isEmpty()){//nếu không có lỗi th thêm vào ds lưu vào DB
                     Department depp = new Department(departmentName);
                     departments.add(depp);
                 }else{
                    importErrors.add(new ImportError(line, String.join(" | ", errors)));
                 }


            }
            // validation dữ liệu

//            //insert vào database
//            for ( Department department : departments){
//                departmentRepository.insertDepartment((department.getDepartmentName()));
//            }
            // xuất ra file list import Errors ra file csv
            String pathError = "E:\\DT2601_JavaCore\\file csv\\output_department_error.csv";
            try(BufferedWriter bw = new BufferedWriter(new FileWriter((pathError)))){
                bw.write("department_name, message_error");
                for(ImportError err: importErrors){
                    bw.write(err.getLine() + "," + err.getMessage());
                    bw.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ( !departments.isEmpty()){
                checkImport =  departmentRepository.createDepartments(departments);
            }
        } catch (Exception e) {
//            message = "import lỗi" + e.getMessage();
        }
        return checkImport ? "import thành công" : "import lỗi, đã xuất file ra E:\\DT2601_JavaCore\\file csv\\output_department_error.csv";
    }
}

//E:\DT2601_JavaCore\file csv\input_department.csv