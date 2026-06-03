package backend.repository.impl;

import backend.repository.IStudentRepository;
import entity.Lecturer;
import entity.Major;
import entity.Student;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    @Override
    public List<Student> showAllStudents() {
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT s.student_id, s.full_name, s.email, s.date_of_birth, m.major_name " +
                    "FROM Student s LEFT JOIN Major m ON s.major_id = m.major_id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setFullName(rs.getString("full_name"));
                s.setEmail(rs.getString("email"));
                s.setDateOfBirth(rs.getDate("date_of_birth"));
                s.setMajorName(rs.getString("major_name"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return list;
    }

    @Override
    public boolean insertStudent(String name, String email, String dob, int majorId) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean isSuccess = false;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO Student(full_name, email, date_of_birth, major_id) VALUES(?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDate(3, java.sql.Date.valueOf(dob));
            ps.setInt(4, majorId);

            isSuccess = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, null);
        }
        return isSuccess;
    }

    @Override
    public boolean updateMajor(int studentId, int majorId) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean isSuccess = false;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "UPDATE Student SET major_id = ? WHERE student_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, majorId);
            ps.setInt(2, studentId);

            isSuccess = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, null);
        }
        return isSuccess;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean isSuccess = false;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "DELETE FROM Student WHERE student_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);

            isSuccess = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, null);
        }
        return isSuccess;
    }

    @Override
    public List<Student> searchByMajorId(int majorId) {
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT s.student_id, s.full_name, s.email, s.date_of_birth, m.major_name " +
                    "FROM Student s INNER JOIN Major m ON s.major_id = m.major_id " +
                    "WHERE s.major_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, majorId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setFullName(rs.getString("full_name"));
                s.setEmail(rs.getString("email"));
                s.setDateOfBirth(rs.getDate("date_of_birth"));
                s.setMajorName(rs.getString("major_name"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return list;
    }

    @Override
    public String checkLogin(String email, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String role = null; // Thay vì biến boolean, ta dùng biến String để hứng role

        try {
            conn = JDBCUtils.getConnection();
            // Sửa câu lệnh SQL: Lấy cột role thay vì đếm COUNT(*)
            String sql = "SELECT role FROM account WHERE email = ? AND password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            // Nếu tìm thấy tài khoản khớp email và password
            if (rs.next()) {
                role = rs.getString("role"); // Lấy chuỗi 'ADMIN', 'LECTURER' hoặc 'STUDENT'
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Giữ nguyên hàm đóng kết nối an toàn của bạn
            JDBCUtils.close(conn, ps, rs);
        }
        return role; // Trả về vai trò (Nếu sai tài khoản sẽ trả về null)
    }

    @Override
    public boolean checkMajorExist(int majorId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isExist = false;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT COUNT(*) FROM Major WHERE major_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, majorId);
            rs = ps.executeQuery();

            if (rs.next()) {
                isExist = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return isExist;
    }

    @Override
    public boolean checkEmailExist(String email) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isExist = false;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT COUNT(*) FROM Student WHERE email = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                isExist = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return isExist;
    }

    @Override
    public boolean checkStudentExist(int studentId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isExist = false;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT COUNT(*) FROM Student WHERE student_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            rs = ps.executeQuery();

            if (rs.next()) {
                isExist = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return isExist;
    }

    @Override
    public Lecturer getLecturerById(int lecturerId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Lecturer l = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM Lecturer WHERE lecturer_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, lecturerId);
            rs = ps.executeQuery();

            if (rs.next()) {
                l = new Lecturer();
                l.setLecturerId(rs.getInt("lecturer_id"));
                l.setFullName(rs.getString("full_name"));
                l.setEmail(rs.getString("email"));
                l.setDepartment(rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return l;
    }

    @Override
    public Integer getMajorIdByName(String majorName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT major_id FROM Major WHERE major_name LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + majorName + "%");
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("major_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return id;
    }
}
