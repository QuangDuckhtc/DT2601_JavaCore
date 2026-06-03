package backend.controller;

import backend.service.IStudentService;
import backend.service.impl.StudentServiceImpl;
import entity.Lecturer;
import entity.Student;

import java.util.List;

public class StudentController {
    private final IStudentService studentService = new StudentServiceImpl();

    /**
     * Câu 2: lấy toàn bộ danh sách sinh viên.
     */
    public List<Student> showAllStudents() {
        return studentService.showAllStudents();
    }

    /**
     * Câu 3: thêm mới sinh viên.
     */
    public boolean insertStudent(String name, String email, String dob, int majorId) {
        return studentService.insertStudent(name, email, dob, majorId);
    }

    /**
     * Câu 4:  cập nhật chuyên ngành mới.
     */
    public boolean updateMajor(int studentId, int majorId) {
        return studentService.updateMajor(studentId, majorId);
    }

    /**
     * Câu 5:  nhận yêu cầu xóa sinh viên theo mã số.
     */
    public boolean deleteStudent(int studentId) {
        return studentService.deleteStudent(studentId);
    }

    /**
     * Câu 6: nhận mã ngành để tìm kiếm danh sách sinh viên.
     */
    public List<Student> searchByMajorId(int majorId) {
        return studentService.searchByMajorId(majorId);
    }

    /**
     * Câu 1:  xác thực tài khoản đăng nhập.
     */
    public String checkLogin(String email, String password) {
        return studentService.checkLogin(email, password);
    }

    /**
     * Kiểm tra  tồn tại của chuyên ngành.
     */
    public boolean checkMajorExist(int majorId) {
        return studentService.checkMajorExist(majorId);
    }

    /**
     * Kiểm tra tồn tại của email.
     */
    public boolean checkEmailExist(String email) {
        return studentService.checkEmailExist(email);
    }

    /**
     * Kiểm tra  tồn tại của sinh viên.
     */
    public boolean checkStudentExist(int studentId) {
        return studentService.checkStudentExist(studentId);
    }

    /**
     * Lấy thông tin giảng viên theo ID.
     */
    public Lecturer getLecturerById(int lecturerId) {
        return studentService.getLecturerById(lecturerId);
    }

    /**
     * Câu 6 bổ trợ: Tìm mã ngành (số) dựa vào tên ngành (chữ) người dùng nhập.
     */
    public Integer getMajorIdByName(String majorName) {
        return studentService.getMajorIdByName(majorName);
    }

    /**
     * Câu 7:  kiểm tra độ an toàn mật khẩu.
     */
    public boolean validatePassword(String password) {
        return studentService.validatePassword(password);
    }
}
