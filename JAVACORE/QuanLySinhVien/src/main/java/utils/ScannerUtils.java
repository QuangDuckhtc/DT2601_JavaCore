package utils;

import java.util.Scanner;

public class ScannerUtils {
    private static final Scanner sc = new Scanner(System.in);

    // NHẬP EMAIL
    public static String inputEmail() {
        while (true) {
            System.out.print("Nhập email: ");
            String email = sc.nextLine().trim();

            if (DataValidator.isEmailValid(email)) {
                return email;
            }

            System.out.println("Email không hợp lệ! (vd: abc@vti.edu.vn)");
        }
    }

    // NHẬP MẬT KHẨU
    public static String inputPassword() {
        while (true) {
            System.out.print("Nhập mật khẩu: ");
            String password = sc.nextLine();

            if (DataValidator.isPasswordValid(password)) {
                return password;
            }

            System.out.println("Mật khẩu không hợp lệ! (8-20 ký tự, có chữ hoa, thường, số, ký tự đặc biệt)");
        }
    }

    //  NHẬP HỌ TÊN
    public static String inputFullName() {
        while (true) {
            System.out.print("Nhập họ tên: ");
            String name = sc.nextLine().trim();

            // Kiểm tra độ dài từ 3-50 VÀ tất cả ký tự phải là chữ  hoặc khoảng trắng
            if (name.length() >= 3 && name.length() <= 50
                    && name.chars().allMatch(c -> Character.isLetter(c) || Character.isWhitespace(c))) {
                return name;
            }
            System.out.println("Họ tên không hợp lệ (3-50 ký tự, chỉ chứa chữ cái)!");
        }
    }

    // NHẬP ID
    public static int inputID() {
        while (true) {
            System.out.print("Nhập ID: ");

            try {
                int id = Integer.parseInt(sc.nextLine().trim());

                if (id > 0) {
                    return id;
                }

                System.out.println("ID phải lớn hơn 0!");
            } catch (Exception e) {
                System.out.println("ID phải là số!");
            }
        }
    }

    //NHẬP CHUỖI
    public static String inputString() {
        return sc.nextLine().trim();
    }
}
