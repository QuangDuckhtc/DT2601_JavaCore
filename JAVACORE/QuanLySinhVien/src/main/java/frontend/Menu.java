package frontend;

import java.util.Scanner;

public class Menu {
    private final StudentFunction program;
    private final Scanner scanner;

    // Constructor
    public Menu(StudentFunction program) {
        this.program = program;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            String role = null;

            while (role == null) {
                role = program.handleLogin();
            }

            // 2. ĐĂNG NHẬP THÀNH CÔNG ->  mở Menu tương ứng
            System.out.println("\n-------------------------------------------------");
            switch (role.toUpperCase()) {
                case "ADMIN":
                    System.out.println("Bạn đã đăng nhập thành công với tư cách là: ADMIN (Quản trị viên)");
                    System.out.println("-------------------------------------------------");
                    showAdminMenu(); // Khi bấm 0, lệnh return ở hàm này sẽ kết thúc hàm và chạy lại vòng lặp while(true) ở trên
                    break;

                case "LECTURER":
                    System.out.println(" Bạn đã đăng nhập thành công với tư cách là: GIẢNG VIÊN");
                    System.out.println("-------------------------------------------------");
                    showLecturerMenu();
                    break;

                case "STUDENT":
                    System.out.println("Bạn đã đăng nhập thành công với tư cách là: SINH VIÊN");
                    System.out.println("-------------------------------------------------");
                    showStudentMenu();
                    break;

                default:
                    System.out.println("Lỗi hệ thống: Vai trò '" + role + "' không hợp lệ!");
            }
        }
    }

    // 1. MENU ĐẦY ĐỦ CHO QUẢN TRỊ VIÊN (ADMIN)
    public void showAdminMenu() {
        while (true) {
            System.out.println("\n=================================================");
            System.out.println("||          MENU QUẢN TRỊ VIÊN (ADMIN)         ||");
            System.out.println("=================================================");
            System.out.println("1. Xem danh sách toàn bộ sinh viên (Câu 2)");
            System.out.println("2. Thêm mới sinh viên vào hệ thống (Câu 3)");
            System.out.println("3. Cập nhật chuyên ngành của sinh viên (Câu 4)");
            System.out.println("4. Xóa sinh viên khỏi hệ thống (Câu 5)");
            System.out.println("5. Tìm kiếm sinh viên theo tên ngành (Câu 6)");
            System.out.println("6. Kiểm tra độ mạnh/yếu của mật khẩu (Câu 7)");
            System.out.println("0. Đăng xuất tài khoản");
            System.out.println("=================================================");
            System.out.print(" Mời Admin nhập lựa chọn (0-6): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    program.handleShowAllStudents(); // Gọi câu 2
                    break;
                case "2":
                    program.handleInsertStudent(); // Gọi câu 3
                    break;
                case "3":
                    program.handleUpdateMajor(); // Gọi câu 4
                    break;
                case "4":
                    program.handleDeleteStudent(); // Gọi câu 5
                    break;
                case "5":
                    program.handleSearchByMajorName(); // Gọi câu 6
                    break;
                case "6":
                    program.handleValidatePassword(); // Gọi câu 7
                    break;
                case "0":
                    System.out.println("Đã đăng xuất quyền Admin thành công!");
                    return; // Thoát menu Admin, quay lại hàm main
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập từ 0 đến 6.");
            }
        }
    }


    // 2. MENU GIỚI HẠN CHO GIẢNG VIÊN (LECTURER)
    public void showLecturerMenu() {
        while (true) {
            System.out.println("\n=================================================");
            System.out.println("||            MENU GIẢNG VIÊN (LECTURER)       ||");
            System.out.println("=================================================");
            System.out.println("1. Xem danh sách toàn bộ sinh viên (Câu 2)");
            System.out.println("2. Tìm kiếm sinh viên theo tên ngành (Câu 6)");
            System.out.println("0. Đăng xuất tài khoản");
            System.out.println("=================================================");
            System.out.print("Mời Giảng viên nhập lựa chọn (0-2): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    program.handleShowAllStudents(); //  gọi câu 2
                    break;
                case "2":
                    program.handleSearchByMajorName(); // gọi câu 6
                    break;
                case "0":
                    System.out.println("Đã đăng xuất tài khoản Giảng viên!");
                    return; // Thoát menu Giảng viên, quay lại hàm main
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập từ 0 đến 2.");
            }
        }
    }

    // 3. MENU GIỚI HẠN CHO SINH VIÊN (STUDENT)
    public void showStudentMenu() {
        while (true) {
            System.out.println("\n=================================================");
            System.out.println("||             MENU SINH VIÊN (STUDENT)        ||");
            System.out.println("=================================================");
            System.out.println("1. Tự kiểm tra độ an toàn mật khẩu cá nhân (Câu 7)");
            System.out.println("0. Đăng xuất tài khoản");
            System.out.println("=================================================");
            System.out.print("Mời Sinh viên nhập lựa chọn (0-1): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    program.handleValidatePassword(); // gọi câu 7
                    break;
                case "0":
                    System.out.println("Đã đăng xuất tài khoản Sinh viên!");
                    return; // Thoát menu Sinh viên, quay lại hàm main
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập 0 hoặc 1.");
            }
        }
    }
}
