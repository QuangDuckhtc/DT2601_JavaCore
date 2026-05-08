package com.vti.backend;

import com.vti.utils.DButils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QLPosition {
    public void getPositions() {

        try {


            Connection connection = DButils.getConnection();

            String sql =
                    "SELECT * FROM position";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
                    "+--------------------------------------+"
            );

            System.out.printf(
                    "| %-10s | %-20s |%n",
                    "ID",
                    "POSITION NAME"
            );

            System.out.println(
                    "+--------------------------------------+"
            );

            while (rs.next()) {

                System.out.printf(
                        "| %-10d | %-20s |%n",

                        rs.getInt("position_id"),

                        rs.getString("position_name")
                );
            }

            System.out.println(
                    "+--------------------------------------+"
            );

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}