package backend.service.impl;

import backend.repository.IStudentRepository;
import backend.repository.impl.StudentRepositoryImpl;
import backend.service.IStudentService;
import entity.Lecturer;
import entity.Student;
import utils.DataValidator;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> showAllStudents() {
        // Câu 2: Gọi thẳng Repository để lấy danh sách sinh viên kèm tên ngành
        return studentRepository.showAllStudents();
    }

    @Override
    public boolean insertStudent(String name, String email, String dob, int majorId) {
        // Validate định dạng trước khi xử lý
        if (!DataValidator.isEmailValid(email)) {
            System.out.println("Lỗi định dạng: Email nhập vào không đúng cấu trúc!");
            return false;
        }
        if (!DataValidator.isDateValid(dob)) {
            System.out.println("Lỗi định dạng: Ngày sinh phải đúng kiểu yyyy-MM-dd!");
            return false;
        }

        // Kiểm tra logic dữ liệu xem có bị trùng lặp hay sai mã ngành không
        if (studentRepository.checkEmailExist(email)) {
            System.out.println("Lỗi hệ thống: Email này đã tồn tại trong Database!");
            return false;
        }
        if (!studentRepository.checkMajorExist(majorId)) {
            System.out.println("Lỗi hệ thống: Mã chuyên ngành này không tồn tại!");
            return false;
        }

        // Nếu tất cả đều ổn, ra lệnh cho Repo lưu xuống DB
        return studentRepository.insertStudent(name, email, dob, majorId);
    }

    @Override
    public boolean updateMajor(int studentId, int majorId) {
        // BÁM SÁT CÂU 4: Phải kiểm tra xem sinh viên có tồn tại hay không
        if (!studentRepository.checkStudentExist(studentId)) {
            System.out.println("Lỗi hệ thống: Không tìm thấy ID sinh viên cần sửa!");
            return false;
        }
        // Kiểm tra xem ngành mới có hợp lệ không
        if (!studentRepository.checkMajorExist(majorId)) {
            System.out.println("Lỗi hệ thống: Mã chuyên ngành mới không tồn tại!");
            return false;
        }

        return studentRepository.updateMajor(studentId, majorId);
    }

    @Override
    public boolean deleteStudent(int studentId) {
        // Phải có sinh viên trong hệ thống mới cho xóa
        if (!studentRepository.checkStudentExist(studentId)) {
            System.out.println("Lỗi hệ thống: ID sinh viên không tồn tại để xóa!");
            return false;
        }
        return studentRepository.deleteStudent(studentId);
    }

    @Override
    public List<Student> searchByMajorId(int majorId) {
        // Câu 6: Tìm danh sách sinh viên theo ID ngành
        return studentRepository.searchByMajorId(majorId);
    }

    @Override
    public String checkLogin(String email, String password) {
        // Câu 1: Xác thực tài khoản đăng nhập
        return studentRepository.checkLogin(email, password);
    }

    @Override
    public boolean checkMajorExist(int majorId) {
        return studentRepository.checkMajorExist(majorId);
    }

    @Override
    public boolean checkEmailExist(String email) {
        return studentRepository.checkEmailExist(email);
    }

    @Override
    public boolean checkStudentExist(int studentId) {
        return studentRepository.checkStudentExist(studentId);
    }

    @Override
    public Lecturer getLecturerById(int lecturerId) {
        return studentRepository.getLecturerById(lecturerId);
    }

    @Override
    public Integer getMajorIdByName(String majorName) {
        // Bổ trợ cho Câu 6: Giúp chuyển đổi Tên ngành (chữ) ra ID ngành (số)
        return studentRepository.getMajorIdByName(majorName);
    }

    @Override
    public boolean validatePassword(String password) {
        // BÁM SÁT CÂU 7: Gọi sang DataValidator ở package common để check mật khẩu mạnh/yếu
        return DataValidator.isPasswordValid(password);
    }


}
