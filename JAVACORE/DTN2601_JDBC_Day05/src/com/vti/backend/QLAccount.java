package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.PositionName;
import com.vti.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QLAccount {
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
}
