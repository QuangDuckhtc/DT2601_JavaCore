package backend.repository.impl;

import backend.repository.IAccountRepository;
import entity.Account;
import entity.Department;
import entity.Position;
import entity.PositionName;
import utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements IAccountRepository {

    @Override
    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();

        try {

            Connection conn = DButils.getConnection();

            String sql =
                    "SELECT a.*, d.department_name, p.position_name " +
                            "FROM account a " +
                            "LEFT JOIN department d ON a.department_id = d.department_id " +
                            "LEFT JOIN position p ON a.position_id = p.position_id";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Account a = new Account();

                a.setAccountID(rs.getInt("account_id"));
                a.setEmail(rs.getString("email"));
                a.setFullName(rs.getString("full_name"));

                Department d = new Department();
                d.setDepartmentName(rs.getString("department_name").toUpperCase());
                a.setDepartment(d);

                Position p = new Position();
                p.setPositionName(PositionName.valueOf(rs.getString("position_name").toUpperCase()));
                a.setPositionName(p.getPositionName());

                a.setCreateDate(rs.getDate("create_date").toLocalDate());

                list.add(a);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Account> findByName(String name) {
        List<Account> list = new ArrayList<>();

        try {

            Connection conn = DButils.getConnection();

            String sql =
                    "SELECT * FROM account WHERE full_name LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Account a = new Account();

                a.setAccountID(rs.getInt("account_id"));
                a.setEmail(rs.getString("email"));
                a.setFullName(rs.getString("full_name"));

                list.add(a);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    @Override
    public boolean insertAccount(String email, String username, String fullName, int departmentId, int positionId) {
        try {

            Connection conn = DButils.getConnection();

            String sql = "INSERT INTO account(email, username, full_name, department_id, position_id) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, username);
            ps.setString(3, fullName);
            ps.setInt(4, departmentId);
            ps.setInt(5, positionId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateAccount(int id, String userName) {
        try {

            Connection conn = DButils.getConnection();

            String sql = "UPDATE account SET username = ? WHERE account_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userName);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteAccount(int id) {
        try {

            Connection conn = DButils.getConnection();

            String sql = "DELETE FROM account WHERE account_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean existsByUsername(String username) {
        try {

            Connection connection = DButils.getConnection();

            String sql = "SELECT COUNT(1) " +
                    "FROM account " +
                    "WHERE username = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        try {

            Connection connection = DButils.getConnection();

            String sql = "SELECT COUNT(1) " +
                    "FROM account " +
                    "WHERE email = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean existsById(int id) {
        try {

            Connection connection = DButils.getConnection();

            String sql = "SELECT COUNT(1) " +
                    "FROM account " +
                    "WHERE account_id = ?";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean updateUsername(int id, String newUsername) {
        try {

            Connection connection = DButils.getConnection();

            String sql =
                    "UPDATE account " +
                            "SET username = ? " +
                            "WHERE account_id = ?";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setString(1, newUsername);
            ps.setInt(2, id);

            int result = ps.executeUpdate();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean existsByUsernameForUpdate(String username, int id) {
        try {

            Connection connection = DButils.getConnection();

            String sql =
                    "SELECT COUNT(1) " +
                            "FROM account " +
                            "WHERE username = ? " +
                            "AND account_id <> ?";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setString(1, username);
            ps.setInt(2, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean createAccounts(List<Account> accounts) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = DButils.getConnection();
            conn.setAutoCommit(false);

            //  DB: email, username, full_name, department_id, position_id
            String sql = "INSERT INTO account " +
                    "(email, username, full_name, department_id, position_id) " +
                    "VALUES (?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);

            for (Account acc : accounts) {
                ps.setString(1, acc.getEmail());
                ps.setString(2, acc.getUsername());
                ps.setString(3, acc.getFullName());
                ps.setInt(4, acc.getDepartment().getDepartmentID());
                ps.setInt(5, acc.getPositionName().ordinal() + 1);
                ps.addBatch();
            }

            ps.executeBatch();
            conn.commit();

            return true;

        } catch (Exception e) {

            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}