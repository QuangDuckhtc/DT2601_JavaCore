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
    //  find by name
    public static List<Position> findByName(String name) {

        List<Position> list = new ArrayList<>();

        try {

            Connection conn = DButils.getConnection();

            String sql = "SELECT * FROM position WHERE position_name LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Position p = new Position();

                p.setPositionID(rs.getInt("position_id"));
                p.setPositionName(PositionName.valueOf(rs.getString("position_name").toUpperCase()));
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    //  insert
    public static boolean insertPosition(String name) {

        try {

            Connection conn = DButils.getConnection();
            String sql = "INSERT INTO position(position_name) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    //  update
    public static boolean updatePosition(int id, String name) {

        try {

            Connection conn = DButils.getConnection();

            String sql = "UPDATE position SET position_name = ? WHERE position_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // delete
    public static boolean deletePosition(String name) {

        try {

            Connection conn = DButils.getConnection();

            String sql = "DELETE FROM position WHERE position_name LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    // most employee
    public static List<Position> getPositionHasMostEmployee() {

        List<Position> list = new ArrayList<>();

        try {

            Connection conn = DButils.getConnection();

            String sql =
                    "SELECT p.position_id, p.position_name, COUNT(a.account_id) AS total " +
                            "FROM position p " +
                            "LEFT JOIN account a ON p.position_id = a.position_id " +
                            "GROUP BY p.position_id, p.position_name " +
                            "HAVING COUNT(a.account_id) = ( " +
                            "   SELECT MAX(cnt) FROM ( " +
                            "       SELECT COUNT(a2.account_id) AS cnt " +
                            "       FROM position p2 " +
                            "       LEFT JOIN account a2 ON p2.position_id = a2.position_id " +
                            "       GROUP BY p2.position_id " +
                            "   ) AS sub " +
                            ")";

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
//    least emloyee
    public static List<Position> getPositionHasLeastEmployee() {

        List<Position> list = new ArrayList<>();

        try {

            Connection conn = DButils.getConnection();

            String sql =
                    "SELECT p.position_id, p.position_name, COUNT(a.account_id) AS total " +
                            "FROM position p " +
                            "LEFT JOIN account a ON p.position_id = a.position_id " +
                            "GROUP BY p.position_id, p.position_name " +
                            "HAVING COUNT(a.account_id) = ( " +
                            "   SELECT MIN(cnt) FROM ( " +
                            "       SELECT COUNT(a2.account_id) AS cnt " +
                            "       FROM position p2 " +
                            "       LEFT JOIN account a2 ON p2.position_id = a2.position_id " +
                            "       GROUP BY p2.position_id " +
                            "   ) AS sub " +
                            ")";

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