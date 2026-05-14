package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
    private static final String URL = "jdbc:mysql://localhost:3307/dtn206_btvn_buoi2";
    private static final String USER = "root";
    private  static final String PASSWORD = "root";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
          URL, USER, PASSWORD
        );
    }
}
