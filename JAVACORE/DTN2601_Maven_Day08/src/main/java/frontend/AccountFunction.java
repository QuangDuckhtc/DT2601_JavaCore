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
    public  void menu() {

        while (true) {

            System.out.println("\n=========== ACCOUNT MENU ===========");
            System.out.println("1. Hiển thị danh sách account");
            System.out.println("2. Tìm account theo email");
            System.out.println("3. Thêm account");
            System.out.println("4. Sửa account");
            System.out.println("5. Xóa account");
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

                case 0:
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }

    //  SHOW ALL
    public  void showAll() {

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
    public  void insert() {

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Department ID: ");
        int depId = scanner.nextInt();

        System.out.print("Position ID: ");
        int posId = scanner.nextInt();
        scanner.nextLine();

        boolean result = accountController.insertAccount(email, username, fullName, depId, posId);

        System.out.println(result ? "Thêm thành công" : "Thêm thất bại");
    }

    //  UPDATE
    public  void update() {

        System.out.print("Nhập ID cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Full name mới: ");
        String fullName = scanner.nextLine();

        boolean result = accountController.updateAccount(id, fullName);

        System.out.println(result ? "Update thành công" : "Update thất bại");
    }

    // DELETE
    public  void delete() {

        System.out.print("Nhập email cần xóa: ");
        String email = scanner.nextLine();

        boolean result = accountController.deleteAccount(email);

        System.out.println(result ? "Xóa thành công" : "Xóa thất bại");
    }
}
