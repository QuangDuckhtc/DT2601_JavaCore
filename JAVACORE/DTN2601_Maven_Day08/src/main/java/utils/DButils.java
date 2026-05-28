package utils;

import java.sql.*;

public class DButils {
    private static final String URL = "jdbc:mysql://localhost:3307/dtn206_btvn_buoi2";
    private static final String USER = "root";
    private  static final String PASSWORD = "root";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
          URL, USER, PASSWORD
        );
    }
    public static void close(Connection connection, Statement statement, ResultSet rs) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
