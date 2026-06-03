package backend.service;

import entity.Lecturer;
import entity.Student;

import java.util.List;

public interface IStudentService {
    // Câu 2: Lấy danh sách hiển thị tất cả sinh viên
    List<Student> showAllStudents();

    // Câu 3: Thêm mới một sinh viên
    boolean insertStudent(String name, String email, String dob, int majorId);

    // Câu 4: Cập nhật chuyên ngành cho sinh viên
    boolean updateMajor(int studentId, int majorId);

    // Câu 5: Xóa sinh viên theo ID
    boolean deleteStudent(int studentId);

    // Câu 6: Tìm danh sách sinh viên theo mã ngành
    List<Student> searchByMajorId(int majorId);

    // Câu 1: Kiểm tra tài khoản đăng nhập hệ thống
    String checkLogin(String email, String password);


    // CÁC HÀM KIỂM TRA BỔ TRỢ (CHECK DATA)

    // Kiểm tra mã ngành có tồn tại trong hệ thống không
    boolean checkMajorExist(int majorId);

    // Kiểm tra email đã được sinh viên nào đăng ký chưa
    boolean checkEmailExist(String email);

    // Kiểm tra mã sinh viên có tồn tại trong máy không
    boolean checkStudentExist(int studentId);

    // Tìm kiếm thông tin chi tiết của Giảng viên qua ID
    Lecturer getLecturerById(int lecturerId);

    // Lấy mã ID chuyên ngành từ Tên chuyên ngành (Ví dụ nhập "Công nghệ thông tin" -> Trả về ID số)
    Integer getMajorIdByName(String majorName);

    // Câu 7: Kiểm tra độ an toàn bảo mật của mật khẩu mới
    boolean validatePassword(String password);
}
