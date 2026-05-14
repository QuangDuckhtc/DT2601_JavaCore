package backend.repository.impl;

import backend.repository.IDepartmentRepository;
import entity.Department;
import utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements IDepartmentRepository {

    @Override
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();

        try {

            Connection conn = DButils.getConnection();

            String sql = "SELECT * FROM department order by department_id asc";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Department d = new Department();
                d.setDepartmentID(rs.getInt("department_id"));
                d.setDepartmentName(rs.getString("department_name"));
                list.add(d);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Department> findByDepartmentIDAndName(int searchId, String searchName) {
        List<Department> departments = new ArrayList<>();
        try {
            Connection cnn = DButils.getConnection();
            String sql = "select * from department where department_id = ? and department_name like ?;";
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setInt(1, searchId);
            preparedStatement.setString(2, searchName);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("department_id");// lấy giá trị từ column department_id
                String name = rs.getString("department_name");//lấy giá trị từ column department_name

                Department dep = new Department(id, name);
                departments.add(dep);
            }
            cnn.close();
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return departments;
    }

    @Override
    public boolean insertDepartment(String newName) {
        try {
            // b1: kết nối đến DB
            Connection connection = DButils.getConnection();
            // b2: tiến hành thêm mới department
            String sql = "insert into department (department_name) values (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newName);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            if (c > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(int deleteId) {
        try {
            // b1: kết nối đến DB
            Connection connection = DButils.getConnection();
            // b2: tiến hành xóa department
            String sql = "delete from department where department_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, deleteId);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            if (c > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    @Override
    public boolean updateDepartment(int id, String updateName) {
        try {
            // b1: kết nối đến DB
            Connection connection = DButils.getConnection();

            // b2: tiến hành update department
            String sql = "update department set department_name = ? where department_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updateName);
            preparedStatement.setInt(2, id);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            if (c > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    @Override
    public List<Department> getDepartmentHasMostEmployee() {
        List<Department> list = new ArrayList<>();

        try {

            Connection conn = DButils.getConnection();

            String sql =
                    "SELECT d.department_id, d.department_name, COUNT(a.account_id) AS total " +
                            "FROM department d " +
                            "LEFT JOIN account a ON d.department_id = a.department_id " +
                            "GROUP BY d.department_id, d.department_name " +
                            "HAVING COUNT(a.account_id) = ( " +
                            "   SELECT MAX(cnt) FROM ( " +
                            "       SELECT COUNT(a2.account_id) AS cnt " +
                            "       FROM department d2 " +
                            "       LEFT JOIN account a2 ON d2.department_id = a2.department_id " +
                            "       GROUP BY d2.department_id " +
                            "   ) AS sub " +
                            ")";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Department d = new Department();

                d.setDepartmentID(rs.getInt("department_id"));
                d.setDepartmentName(rs.getString("department_name"));

                list.add(d);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Department> getDepartmentHasLeastEmployee() {
        List<Department> list = new ArrayList<>();

        try {

            Connection conn = DButils.getConnection();

            String sql =
                    "SELECT d.department_id, d.department_name, COUNT(a.account_id) AS total " +
                            "FROM department d " +
                            "LEFT JOIN account a ON d.department_id = a.department_id " +
                            "GROUP BY d.department_id, d.department_name " +
                            "HAVING COUNT(a.account_id) = ( " +
                            "   SELECT MIN(cnt) FROM ( " +
                            "       SELECT COUNT(a2.account_id) AS cnt " +
                            "       FROM department d2 " +
                            "       LEFT JOIN account a2 ON d2.department_id = a2.department_id " +
                            "       GROUP BY d2.department_id " +
                            "   ) AS sub " +
                            ")";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Department d = new Department();

                d.setDepartmentID(rs.getInt("department_id"));
                d.setDepartmentName(rs.getString("department_name"));

                list.add(d);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

