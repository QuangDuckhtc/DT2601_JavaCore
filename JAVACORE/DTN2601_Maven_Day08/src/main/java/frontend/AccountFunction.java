package frontend;

import backend.controller.AccountController;
import entity.Account;
import utils.TablePrinter;

import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);
    AccountController accountController = new AccountController();

    // ================= MENU =================
    public void menu() {

        while (true) {

            System.out.println("\n=========== ACCOUNT MENU ===========");
            System.out.println("1. Hiển thị danh sách account");
            System.out.println("2. Tìm account theo email");
            System.out.println("3. Thêm account");
            System.out.println("4. Sửa account");
            System.out.println("5. Xóa account");
            System.out.println("6. Import  account từ file csv");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    showAll();
                    break;

                case 2:
                    findByEmail();
                    break;

                case 3:
                    insert();
                    break;

                case 4:
                    update();
                    break;

                case 5:
                    delete();
                    break;
                case 6:
                    importDepartmentToCSV();
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }

    private void importDepartmentToCSV() {
        System.out.println("Nhập địa chỉ file cần import: ");

        String pathName = scanner.nextLine();

        String message = accountController.importAccountToCSV(pathName);

        System.out.println(message);
    }

    //  SHOW ALL
    public void showAll() {

        List<Account> list = accountController.getAllAccounts();

        System.out.println("\n--- ACCOUNT LIST ---");

        TablePrinter.printAccountHeader();

        for (Account a : list) {
            TablePrinter.printAccountRow(
                    a.getAccountID(),
                    a.getEmail(),
                    a.getFullName()
            );
        }

        TablePrinter.printAccountFooter();
    }

    // FIND BY EMAIL
    public void findByEmail() {

        System.out.print("Nhập email: ");
        String name = scanner.nextLine();

        List<Account> list = accountController.findByName(name);

        System.out.println("\n--- SEARCH RESULT ---");

        TablePrinter.printAccountHeader();

        for (Account a : list) {
            TablePrinter.printAccountRow(
                    a.getAccountID(),
                    a.getEmail(),
                    a.getFullName()
            );
        }

        TablePrinter.printAccountFooter();
    }

    // INSERT
    public void insert() {

        String email;

        while (true) {

            System.out.print("Email: ");
            email = scanner.nextLine();

            if (email.trim().isEmpty()) {

                System.out.println("Email không được để trống");

                continue;
            }

            break;
        }

        String username;

        while (true) {

            System.out.print("Username: ");
            username = scanner.nextLine();

            if (username.trim().isEmpty()) {

                System.out.println("Username không được để trống");

                continue;
            }

            break;
        }

        String fullName;

        while (true) {

            System.out.print("Full name: ");
            fullName = scanner.nextLine();

            if (fullName.trim().isEmpty()) {

                System.out.println("Full name không được để trống");

                continue;
            }

            break;
        }

        int depId;

        while (true) {

            System.out.print("Department ID: ");
            depId = scanner.nextInt();

            if (depId <= 0) {

                System.out.println("Department ID phải lớn hơn 0");
                continue;
            }

            break;
        }

        int posId;

        while (true) {

            System.out.print("Position ID: ");
            posId = scanner.nextInt();

            if (posId <= 0) {

                System.out.println("Position ID phải lớn hơn 0");

                continue;
            }

            break;
        }

        scanner.nextLine();

        boolean result = accountController.insertAccount(email, username, fullName, depId, posId);

        System.out.println(result ? "Thêm thành công" : "Thêm thất bại");
    }

    //  UPDATE
    public void update() {

        int id;

        while (true) {

            System.out.print("Nhập ID cần sửa: ");
            id = scanner.nextInt();
            scanner.nextLine();

            if (id <= 0) {

                System.out.println("ID phải lớn hơn 0");

                continue;
            }

            break;
        }

        String newUsername;

        while (true) {

            System.out.print("Username mới: ");
            newUsername = scanner.nextLine();

            if (newUsername.trim().isEmpty()) {

                System.out.println("Username không được để trống");

                continue;
            }

            break;
        }

        boolean result = accountController.updateAccount(id, newUsername);

        System.out.println(result ? "Update thành công" : "Update thất bại");
    }

    // DELETE
    public void delete() {

        int id;

        while (true) {

            System.out.print("Nhập ID cần xóa: ");
            id = scanner.nextInt();

            if (id <= 0) {

                System.out.println("ID phải lớn hơn 0"
                );
                continue;
            }

            break;
        }

        boolean result = accountController.deleteAccount(id);

        System.out.println(result ? "Xóa thành công" : "Xóa thất bại");
    }
}
