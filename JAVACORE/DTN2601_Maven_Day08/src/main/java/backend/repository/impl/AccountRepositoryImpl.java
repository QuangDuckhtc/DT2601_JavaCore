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
    public boolean updateAccount(int id, String fullName) {
        try {

            Connection conn = DButils.getConnection();

            String sql = "UPDATE account SET full_name = ? WHERE account_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, fullName);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteAccount(String name) {
        try {

            Connection conn = DButils.getConnection();

            String sql = "DELETE FROM account WHERE full_name LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}

