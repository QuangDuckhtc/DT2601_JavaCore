package entity;

import java.util.Date;

public class Student{
    // Các trường dữ liệu khớp chính xác với các cột trong Database
    private int studentId;
    private String fullName;
    private String email;
    private Date dateOfBirth;
    private int majorId;

    // Trường bổ sung để lưu tên chuyên ngành khi SELECT JOIN từ bảng Major
    private String majorName;

    // Constructor mặc định (Không tham số) - Bắt buộc phải có trong Java Beans
    public Student() {
    }

    // Constructor đầy đủ tham số để dùng khi lấy dữ liệu từ DB lên
    public Student(int studentId, String fullName, String email, Date dateOfBirth, int majorId, String majorName) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.majorId = majorId;
        this.majorName = majorName;
    }

    // --- CÁC HÀM GETTER VÀ SETTER (ĐỂ TRUY XUẤT DỮ LIỆU) ---

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
