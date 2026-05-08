package com.vti.backend;

import com.vti.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QLDepartment {
    public void getDepartment (){
        try {
            Connection connection = DButils.getConnection();
            String sql = "SELECT * FROM department";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("+==========+====================+");

            System.out.printf("%-10s |%-20s|%n", "ID", "NAME");
            System.out.println("+==========+====================+");
            while (rs.next()){
                System.out.printf("%-10d |%-20s|%n", rs.getInt("Department_id"), rs.getString("department_name"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
