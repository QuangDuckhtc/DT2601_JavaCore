package backend.repository;

import entity.Lecturer;
import entity.Student;

import java.util.List;

public interface IStudentRepository {
    //  CÁC HÀM CHỨC NĂNG CHÍNH
    List<Student> showAllStudents(); // Hiển thị tất cả sinh viên

    boolean insertStudent(String name, String email, String dob, int majorId); // Thêm sinh viên

    boolean updateMajor(int studentId, int majorId); // Cập nhật chuyên ngành

    boolean deleteStudent(int studentId); // Xóa sinh viên

    List<Student> searchByMajorId(int majorId); // Tìm sinh viên theo mã ngành

    String checkLogin(String email, String password); // Kiểm tra đăng nhập

    //  HÀM KIỂM TRA BỔ TRỢ (CHECK DATA)
    boolean checkMajorExist(int majorId); // Kiểm tra xem mã ngành có tồn tại không

    boolean checkEmailExist(String email); // Kiểm tra xem email đã có chưa

    boolean checkStudentExist(int studentId); // Kiểm tra xem mã sinh viên có tồn tại không

    Lecturer getLecturerById(int lecturerId); // Lấy thông tin giảng viên qua ID

    Integer getMajorIdByName(String majorName); // Lấy mã ngành từ tên ngành
}
