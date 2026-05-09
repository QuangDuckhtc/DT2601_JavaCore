package com.vti.backend;

import com.vti.entity.Department;
import com.vti.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {
    public List<Department> getAllDepartments() {

        List<Department> list = new ArrayList<>();

        try {

            Connection conn = DButils.getConnection();

            String sql = "SELECT * FROM department";

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
