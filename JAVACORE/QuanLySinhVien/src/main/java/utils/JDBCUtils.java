package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {
    private static final String URL = "jdbc:mysql://localhost:3307/Student_Management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    // Hàm lấy connection kết nối tới database
    public static Connection getConnection() {
        try {
            // Nếu chưa có connection hoặc đã bị đóng thì tạo mới
            if (connection == null || connection.isClosed()) {

                // Load driver MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Tạo connection tới database
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }

        } catch (Exception e) {
            System.out.println("Không thể kết nối database");
            e.printStackTrace();
        }

        return connection;
    }

    // Hàm đóng tài nguyên sau khi sử dụng
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {

            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
