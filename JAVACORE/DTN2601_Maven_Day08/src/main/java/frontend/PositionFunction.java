package frontend;

import backend.controller.PositionController;
import entity.Position;
import entity.PositionName;
import utils.TablePrinter;

import java.util.List;
import java.util.Scanner;

public class PositionFunction {
    private static Scanner scanner = new Scanner(System.in);
   PositionController positionController = new PositionController();

    // ================= MENU =================
    public  void menu() {

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
    public  void showAll() {

        List<Position> list = positionController.getAllPositions();

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
    public  void findByName() {

        System.out.print("Nhập name: ");
        String name = scanner.nextLine();

        List<Position> list = positionController.findByName(name);

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
    public  void insert() {

        System.out.print("Nhập position name: ");
        String name = scanner.nextLine();

        PositionName positionName = PositionName.valueOf(name.toUpperCase());

        boolean result = positionController.insertPosition(positionName);

        System.out.println(result ? "Thêm thành công" : "Thêm thất bại");
    }

    //  UPDATE
    public  void update() {

        System.out.print("Nhập ID cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập name mới: ");
        String name = scanner.nextLine();

        boolean result = positionController.updatePosition(id, name);

        System.out.println(result ? "Update thành công" : "Update thất bại");
    }

    //  DELETE
    public  void delete() {

        System.out.print("Nhập id cần xóa: ");
        int id = scanner.nextInt();

        boolean result = positionController.deletePosition(id);

        System.out.println(result ? "Xóa thành công" : "Xóa thất bại");
    }

    // MOST EMPLOYEE
    public  void mostEmployee() {

        List<Position> list = positionController.getPositionHasMostEmployee();

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
    public  void leastEmployee() {

        List<Position> list = positionController.getPositionHasLeastEmployee();

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
