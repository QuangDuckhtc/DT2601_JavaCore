package com.vti.backend;

import com.vti.entity.Position;
import com.vti.entity.PositionName;
import com.vti.utils.DButils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QLPosition {

    public List<Position> getAllPositions() {

        List<Position> list = new ArrayList<>();

        try {
            Connection conn = DButils.getConnection();
            String sql = "SELECT * FROM position";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Position p = new Position();
                p.setPositionID(rs.getInt("position_id"));
                p.setPositionName(PositionName.valueOf(rs.getString("position_name").toUpperCase()));
                list.add(p);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}