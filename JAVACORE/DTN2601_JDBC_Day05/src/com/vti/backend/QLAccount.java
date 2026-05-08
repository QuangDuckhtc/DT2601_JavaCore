package com.vti.backend;

import com.vti.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QLAccount {
    public void getAccounts() {

        try {
            Connection connection = DButils.getConnection();
            String sql = "SELECT a.account_id, " +
                    "a.email, " +
                    "a.full_name, " +
                    "d.department_name, " +
                    "p.position_name, " +
                    "a.create_date " +
                    "FROM account a " +
                    "LEFT JOIN department d " +
                    "ON a.department_id = d.department_id " +
                    "LEFT JOIN position p " +
                    "ON a.position_id = p.position_id";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
                    "+----------------------------------------------------------------------------------------------------------------------+"
            );

            System.out.printf(
                    "| %-5s | %-25s | %-20s | %-20s | %-15s | %-15s |%n",
                    "ID",
                    "EMAIL",
                    "FULL NAME",
                    "DEPARTMENT",
                    "POSITION",
                    "CREATE DATE"
            );
            System.out.println(
                    "+----------------------------------------------------------------------------------------------------------------------+"
            );

            while (rs.next()) {
                System.out.printf(
                        "| %-5d | %-25s | %-20s | %-20s | %-15s | %-15s |%n",

                        rs.getInt("account_id"),

                        rs.getString("email"),

                        rs.getString("full_name"),

                        rs.getString("department_name"),

                        rs.getString("position_name"),

                        rs.getTimestamp("create_date")

                );
            }
            System.out.println(
                    "+----------------------------------------------------------------------------------------------------------------------+"
            );
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
