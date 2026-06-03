package frontend;

import backend.controller.StudentController;
import backend.service.impl.StudentServiceImpl;
import entity.Lecturer;
import entity.Student;

import java.util.List;
import java.util.Scanner;

public class StudentFunction {
    private final StudentController studentController = new StudentController();
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentServiceImpl studentService = new StudentServiceImpl();

    /**
     * Câu 1: Xử lý Đăng nhập hệ thống trước khi vào Menu chính
     * Ép người dùng không được để trống tài khoản/mật khẩu
     */
    public String handleLogin() {
        System.out.println("\n+-------------------------------------------+");
        System.out.println("|             ĐĂNG NHẬP HỆ THỐNG            |");
        System.out.println("+-------------------------------------------+");

        String email = "";
        while (true) {
            System.out.print("Nhập Email tài khoản: ");
            email = scanner.nextLine().trim();
            if (!email.isEmpty()) break;
            System.out.println(" Lỗi: Email tài khoản không được để trống!");
        }

        String password = "";
        while (true) {
            System.out.print("Nhập Mật khẩu: ");
            password = scanner.nextLine(); // Giữ nguyên mật khẩu thô (không trim) đề phòng có khoảng trắng cố ý
            if (!password.isEmpty())
                break;
            System.out.println("Lỗi: Mật khẩu không được để trống!");
        }
        System.out.println("+-------------------------------------------+");

        String role = studentController.checkLogin(email, password);

        //  Nếu role khác null nghĩa là có tài khoản này trong DB
        if (role != null) {
            System.out.println("Đăng nhập thành công! Quyền hạn của bạn: " + role.toUpperCase());
            return role; // Trả chuỗi vai trò về để hàm main điều hướng menu
        } else {
            System.out.println("Sai tài khoản hoặc mật khẩu! Vui lòng thử lại.");
            return null; // Trả về null nếu đăng nhập thất bại
        }
    }

    /**
     * Câu 2: Hiển thị danh sách toàn bộ sinh viên dạng BẢNG ĐẸP
     */
    public void handleShowAllStudents() {
        List<Student> list = studentController.showAllStudents();

        if (list.isEmpty()) {
            System.out.println("\n Hệ thống hiện chưa có dữ liệu sinh viên.");
            return;
        }

        System.out.println("\n DANH SÁCH TOÀN BỘ SINH VIÊN HIỆN TẠI");
        printStudentTableDivider();
        System.out.printf("| %-5s | %-22s | %-25s | %-12s | %-20s |\n",
                "ID", "Họ và Tên", "Email", "Ngày Sinh", "Chuyên Ngành");
        printStudentTableDivider();

        for (Student s : list) {
            System.out.printf("| %-5d | %-22s | %-25s | %-12s | %-20s |\n",
                    s.getStudentId(),
                    s.getFullName(),
                    s.getEmail(),
                    s.getDateOfBirth() != null ? s.getDateOfBirth().toString() : "N/A",
                    s.getMajorName() != null ? s.getMajorName() : "Chưa xếp lớp");
        }
        printStudentTableDivider();
    }

    /**
     * Câu 3: Thêm mới sinh viên sử dụng bộ lọc "Chặn lỗi tại chỗ"
     */
    public void handleInsertStudent() {
        System.out.println("\n+-------------------------------------------------------+");
        System.out.println("|                   THÊM MỚI SINH VIÊN                  |");
        System.out.println("+-------------------------------------------------------+");

        // TRẠM 1: Nhập và kiểm tra Họ tên
        String name = "";
        while (true) {
            System.out.print("  Nhập họ và tên: ");
            name = scanner.nextLine().trim();
            if (name.length() >= 3 && name.length() <= 50
                    && name.chars().allMatch(c -> Character.isLetter(c) || Character.isWhitespace(c))) {
                break;
            }
            System.out.println(" Lỗi: Họ tên phải từ 3-50 ký tự, chỉ chứa chữ cái và khoảng trắng!");
        }

        // TRẠM 2: Nhập và kiểm tra định dạng Email + Check trùng trong Database
        String email = "";
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        while (true) {
            System.out.print(" Nhập Email sinh viên: ");
            email = scanner.nextLine().trim();

            if (email.length() > 100 || !java.util.regex.Pattern.matches(emailRegex, email)) {
                System.out.println(" Lỗi định dạng: Email không đúng cấu trúc hoặc vượt quá 100 ký tự!");
                continue;
            }
            if (studentService.checkEmailExist(email)) {
                System.out.println("  Lỗi trùng lặp: Email này ĐÃ TỒN TẠI trên hệ thống! Vui lòng chọn Email khác.");
            } else {
                break;
            }
        }

        // TRẠM 3: Nhập và kiểm tra định dạng Ngày sinh
        String dob = "";
        while (true) {
            System.out.print("  Nhập ngày sinh (yyyy-MM-dd): ");
            dob = scanner.nextLine().trim();
            try {
                java.sql.Date.valueOf(dob); // Tự động chặn ngày ảo như 31/02
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("  Định dạng sai: Vui lòng nhập đúng kiểu Năm-Tháng-Ngày (VD: 2004-05-15)!");
            }
        }

        // TRẠM 4: Nhập và kiểm tra định dạng Mã ngành + Check tồn tại trong Database
        int majorId = 0;
        while (true) {
            System.out.print("  Nhập Mã số chuyên ngành (ID ngành): ");
            try {
                majorId = Integer.parseInt(scanner.nextLine().trim());
                if (majorId <= 0) {
                    System.out.println("  Lỗi: Mã chuyên ngành phải là số nguyên dương lớn hơn 0!");
                    continue;
                }
                if (!studentService.checkMajorExist(majorId)) {
                    System.out.println("  Lỗi Database: Mã ngành " + majorId + " không tồn tại trên hệ thống!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Lỗi nhập liệu: Vui lòng gõ ký tự số, không gõ chữ!");
            }
        }

        System.out.println("+-------------------------------------------------------+");

        // Dữ liệu vượt qua 4 trạm gác chắc chắn an toàn 100%
        boolean isSuccess = studentController.insertStudent(name, email, dob, majorId);
        if (isSuccess) {
            System.out.println(" THÀNH CÔNG: Đã thêm mới sinh viên vào hệ thống!");
        } else {
            System.out.println("  THẤT BẠI: Lỗi hệ thống phát sinh.");
        }
    }

    /**
     * Câu 4: Cập nhật chuyên ngành mới cho sinh viên
     */
    public void handleUpdateMajor() {
        System.out.println("\n+-------------------------------------------------------+");
        System.out.println("|                 CẬP NHẬT CHUYÊN NGÀNH                 |");
        System.out.println("+-------------------------------------------------------+");

        int studentId = 0;
        while (true) {
            System.out.print(" Nhập Mã số (ID) sinh viên cần chuyển ngành: ");
            try {
                studentId = Integer.parseInt(scanner.nextLine().trim());
                if (studentId > 0) break;
                System.out.println("  ID sinh viên phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println(" Vui lòng nhập số nguyên, không nhập chữ!");
            }
        }

        int majorId = 0;
        while (true) {
            System.out.print(" Nhập Mã số (ID) chuyên ngành mới: ");
            try {
                majorId = Integer.parseInt(scanner.nextLine().trim());
                if (majorId <= 0) {
                    System.out.println(" Mã chuyên ngành phải lớn hơn 0!");
                    continue;
                }
                if (!studentService.checkMajorExist(majorId)) {
                    System.out.println("  Lỗi Database: Mã ngành " + majorId + " không tồn tại!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("  Vui lòng nhập số nguyên, không nhập chữ!");
            }
        }
        System.out.println("+-------------------------------------------------------+");

        boolean isSuccess = studentController.updateMajor(studentId, majorId);
        if (isSuccess) {
            System.out.println("   THÀNH CÔNG: Đã chuyển ngành thành công!");
        } else {
            System.out.println("  THẤT BẠI: Không tìm thấy sinh viên mang ID [" + studentId + "] trên hệ thống.");
        }
    }

    /**
     * Câu 5: Xóa sinh viên ra khỏi hệ thống
     */
    public void handleDeleteStudent() {
        System.out.println("\n+-------------------------------------------------------+");
        System.out.println("|                     XÓA SINH VIÊN                     |");
        System.out.println("+-------------------------------------------------------+");

        int studentId = 0;
        while (true) {
            System.out.print(" Nhập Mã số (ID) sinh viên cần xóa: ");
            try {
                studentId = Integer.parseInt(scanner.nextLine().trim());
                if (studentId > 0) break;
                System.out.println("  ID sinh viên phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("  Vui lòng nhập số nguyên!");
            }
        }
        System.out.println("+-------------------------------------------------------+");

        System.out.print(" ⚠ Bạn có thực sự muốn xóa sinh viên này không? (Y/N): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("Y")) {
            boolean isSuccess = studentController.deleteStudent(studentId);
            if (isSuccess) {
                System.out.println("  THÀNH CÔNG: Dữ liệu sinh viên đã được xóa sạch.");
            } else {
                System.out.println("  THẤT BẠI: Không tìm thấy sinh viên có ID này để xóa.");
            }
        } else {
            System.out.println(" Đã hủy thao tác xóa dữ liệu.");
        }
    }

    /**
     * Câu 6: Tìm kiếm sinh viên theo Tên chuyên ngành
     */
    public void handleSearchByMajorName() {
        System.out.println("\n--- TÌM KIẾM THEO TÊN CHUYÊN NGÀNH ---");
        System.out.print("Nhập tên ngành muốn tìm kiếm (Ví dụ: Công nghệ thông tin): ");
        String majorName = scanner.nextLine().trim();

        Integer majorId = studentController.getMajorIdByName(majorName);
        if (majorId == null) {
            System.out.println("  Không tìm thấy chuyên ngành nào khớp với từ khóa [" + majorName + "]");
            return;
        }

        List<Student> list = studentController.searchByMajorId(majorId);
        if (list.isEmpty()) {
            System.out.println(" ℹ Ngành [" + majorName + "] hiện chưa có sinh viên nào.");
        } else {
            System.out.println("\n KẾT QUẢ TÌM KIẾM SINH VIÊN THUỘC NGÀNH: " + majorName.toUpperCase());
            printSearchTableDivider();
            System.out.printf("| %-5s | %-22s | %-25s |\n", "ID", "Họ và Tên", "Email");
            printSearchTableDivider();
            for (Student s : list) {
                System.out.printf("| %-5d | %-22s | %-25s |\n", s.getStudentId(), s.getFullName(), s.getEmail());
            }
            printSearchTableDivider();
        }
    }

    /**
     * Câu 7: Kiểm tra độ an toàn bảo mật của mật khẩu mới
     */
    public void handleValidatePassword() {
        System.out.println("\n--- KIỂM TRA ĐỘ MẠNH MẬT KHẨU ---");
        System.out.print("Nhập mật khẩu bạn muốn kiểm tra: ");
        String password = scanner.nextLine(); // Nhận mật khẩu từ người dùng

        // 1. Kiểm tra độ dài trước
        if (password.length() < 8 || password.length() > 20) {
            System.out.println(" CẢNH BÁO: Mật khẩu không hợp lệ!");
            System.out.println(" Lý do: Độ dài hiện tại là " + password.length() + " ký tự. (Yêu cầu bắt buộc: Từ 8 đến 20 ký tự).");
            return; // Dừng hàm luôn
        }

        // 2. Nếu độ dài đã đạt chuẩn (8-20), tiến hành kiểm tra độ phức tạp bằng Regex
        boolean isValid = studentController.validatePassword(password);
        if (isValid) {
            System.out.println("ĐẠT CHUẨN: Mật khẩu này rất an toàn!");
        } else {
            System.out.println(" CẢNH BÁO: Mật khẩu yếu!");
            System.out.println(" Lý do: Chưa hội tụ đủ các yếu tố: Chứa chữ HOA, chữ thường, số, ký tự đặc biệt hoặc đang bị dính khoảng trắng.");
        }
    }



    private void printStudentTableDivider() {
        System.out.println("+-------+------------------------+---------------------------+--------------+----------------------+");
    }

    private void printSearchTableDivider() {
        System.out.println("+-------+------------------------+---------------------------+");
    }
}
