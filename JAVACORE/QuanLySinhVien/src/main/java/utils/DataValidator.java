package utils;

import java.util.regex.Pattern;

public class DataValidator {
    // Câu 7: Kiểm tra mật khẩu (Độ dài 8-20 ký tự, có chữ Hoa, chữ Thường, Số và Ký tự đặc biệt)
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+!])(?=\\S+$).{8,20}$";

    // Kiểm tra định dạng Email chuẩn
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    /* Hàm kiểm tra cấu trúc Email nhập vào từ bàn phím.
     */
    public static boolean isEmailValid(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    /**
     * Câu 7: Hàm kiểm tra xem mật khẩu mới có đủ độ an toàn bảo mật hay không.
     */
    public static boolean isPasswordValid(String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    /**
     * Hàm kiểm tra chuỗi ngày sinh người dùng nhập vào có đúng kiểu yyyy-MM-dd không.
     */
    public static boolean isDateValid(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return false;
        }
        try {
            java.sql.Date.valueOf(dateStr);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
