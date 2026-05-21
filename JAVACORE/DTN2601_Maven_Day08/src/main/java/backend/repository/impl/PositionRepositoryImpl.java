package backend.repository.impl;

import backend.repository.IPositionRepository;
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

public class PositionRepositoryImpl implements IPositionRepository {

    @Override
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

    @Override
    public List<Position> findByName(String name) {
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

    @Override
    public boolean insertPosition(String name) {
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

    @Override
    public boolean updatePosition(int id, String name) {
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

    @Override
    public boolean deletePosition(int id) {
        try {

            Connection conn = DButils.getConnection();

            String sql = "DELETE FROM position WHERE position_id  = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Position> getPositionHasMostEmployee() {
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

    @Override
    public List<Position> getPositionHasLeastEmployee() {
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

    @Override
    public boolean existsByName(String name) {
        try {

            // b1: kết nối DB
            Connection connection =
                    DButils.getConnection();

            // b2: tạo câu SQL
            String sql =
                    "SELECT COUNT(1) " +
                            "FROM position " +
                            "WHERE position_name = ?";

            // b3: tạo prepared statement
            PreparedStatement ps =
                    connection.prepareStatement(sql);

            // b4: truyền dữ liệu
            ps.setString(1, name);

            // b5: execute query
            ResultSet rs = ps.executeQuery();

            // b6: xử lý kết quả
            if (rs.next()) {

                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean existsByNameForUpdate(String name, int id) {
        try {

            Connection connection =
                    DButils.getConnection();

            String sql =
                    "SELECT COUNT(1) " +
                            "FROM position " +
                            "WHERE position_name = ? " +
                            "AND position_id <> ?";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setString(1, name);
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
    public boolean existsById(int id) {
        try {

            Connection connection = DButils.getConnection();

            String sql = "SELECT COUNT(1) " +
                    "FROM position " +
                    "WHERE position_id = ?";

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
}
