package com.vti.frontend;

import com.vti.backend.QLPosition;
import com.vti.entity.Position;
import com.vti.utils.TablePrinter;

import java.util.List;
import java.util.Scanner;

public class PositionFunction {
    private static Scanner scanner = new Scanner(System.in);
    private static QLPosition qlPosition = new QLPosition();

    // ================= MENU =================
    public static void menu() {

        while (true) {

            System.out.println("\n=========== POSITION MENU ===========");
            System.out.println("1. Hiển thị danh sách position");
            System.out.println("2. Tìm position theo name");
            System.out.println("3. Thêm position");
            System.out.println("4. Sửa position");
            System.out.println("5. Xóa position");
            System.out.println("6. Position nhiều nhân viên nhất");
            System.out.println("7. Position ít nhân viên nhất");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    showAll();
                    break;

                case 2:
                    findByName();
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
                    mostEmployee();
                    break;

                case 7:
                    leastEmployee();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }

    // SHOW ALL
    public static void showAll() {

        List<Position> list = qlPosition.getAllPositions();

        System.out.println("\n--- POSITION LIST ---");

        TablePrinter.printPositionHeader();

        for (Position p : list) {
            TablePrinter.printPositionRow(
                    p.getPositionID(),
                    p.getPositionName().name()
            );
        }

        TablePrinter.printPositionFooter();
    }

    // FIND
    public static void findByName() {

        System.out.print("Nhập name: ");
        String name = scanner.nextLine();

        List<Position> list = qlPosition.findByName(name);

        System.out.println("\n--- SEARCH RESULT ---");

        TablePrinter.printPositionHeader();

        for (Position p : list) {
            TablePrinter.printPositionRow(
                    p.getPositionID(),
                    p.getPositionName().name()
            );
        }

        TablePrinter.printPositionFooter();
    }

    //  INSERT
    public static void insert() {

        System.out.print("Nhập position name: ");
        String name = scanner.nextLine();

        boolean result = qlPosition.insertPosition(name);

        System.out.println(result ? "Thêm thành công" : "Thêm thất bại");
    }

    //  UPDATE
    public static void update() {

        System.out.print("Nhập ID cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập name mới: ");
        String name = scanner.nextLine();

        boolean result = qlPosition.updatePosition(id, name);

        System.out.println(result ? "Update thành công" : "Update thất bại");
    }

    //  DELETE
    public static void delete() {

        System.out.print("Nhập name cần xóa: ");
        String name = scanner.nextLine();

        boolean result = qlPosition.deletePosition(name);

        System.out.println(result ? "Xóa thành công" : "Xóa thất bại");
    }

    // MOST EMPLOYEE
    public static void mostEmployee() {

        List<Position> list = qlPosition.getPositionHasMostEmployee();

        System.out.println("\n--- POSITION MOST EMPLOYEE ---");

        TablePrinter.printPositionHeader();

        for (Position p : list) {
            TablePrinter.printPositionRow(
                    p.getPositionID(),
                    p.getPositionName().name().toUpperCase()
            );
        }

        TablePrinter.printPositionFooter();
    }

    //  LEAST EMPLOYEE
    public static void leastEmployee() {

        List<Position> list = qlPosition.getPositionHasLeastEmployee();

        System.out.println("\n--- POSITION LEAST EMPLOYEE ---");

        TablePrinter.printPositionHeader();

        for (Position p : list) {
            TablePrinter.printPositionRow(
                    p.getPositionID(),
                    p.getPositionName().name().toUpperCase()
            );
        }

        TablePrinter.printPositionFooter();
    }
}
