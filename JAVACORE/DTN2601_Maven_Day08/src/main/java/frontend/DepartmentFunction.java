package frontend;

import backend.controller.DepartmentController;
import entity.Department;
import utils.TablePrinter;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DepartmentFunction {
    private static Scanner scanner = new Scanner(System.in);
    DepartmentController departmentController = new DepartmentController();

    // ================= MENU =================
    public void menu() {

        while (true) {

            System.out.println("\n=========== DEPARTMENT MENU ===========");
            System.out.println("1. Hiển thị danh sách department");
            System.out.println("2. Tìm department theo ID + Name");
            System.out.println("3. Thêm department");
            System.out.println("4. Sửa department");
            System.out.println("5. Xóa department");
            System.out.println("6. Department nhiều nhân viên nhất");
            System.out.println("7. Department ít nhân viên nhất");
            System.out.println("8. Import phòng ban từ file csv ");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            int choice;
            try {

                choice = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {

                System.out.println("Vui lòng nhập số!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    showAll();
                    break;

                case 2:
                    findByIdAndName();
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
                case 8:
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
        departmentController.importDepartmentToCSV(pathName);
        String message = departmentController.importDepartmentToCSV(pathName);
        System.out.println(message);
    }

    //SHOW ALL
    public void showAll() {

        List<Department> list = departmentController.getAllDepartments();

        System.out.println("\n--- DEPARTMENT LIST ---");

        TablePrinter.printDepartmentHeader();

        for (Department d : list) {
            TablePrinter.printDepartmentRow(
                    d.getDepartmentID(),
                    d.getDepartmentName()
            );
        }

        TablePrinter.printDepartmentFooter();
    }

    //  FIND
    public void findByIdAndName() {

        System.out.print("Nhập ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập name: ");
        String name = scanner.nextLine();

        List<Department> list = departmentController.findByDepartmentIDAndName(id, name);

        System.out.println("\n--- SEARCH RESULT ---");

        TablePrinter.printDepartmentHeader();

        for (Department d : list) {
            TablePrinter.printDepartmentRow(
                    d.getDepartmentID(),
                    d.getDepartmentName()
            );
        }

        TablePrinter.printDepartmentFooter();
    }

    //INSERT
    public void insert() {

        String name;

        while (true) {

            System.out.print("Nhập tên phòng ban: ");
            name = scanner.nextLine();

            if (name.trim().isEmpty()) {

                System.out.println(
                        "Tên phòng ban không được để trống"
                );

                continue;
            }

            break;
        }

        boolean result = departmentController.insertDepartment(name);

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

        String newName;

        while (true) {

            System.out.print("Tên phòng ban mới: ");
            newName = scanner.nextLine();

            if (newName.trim().isEmpty()) {

                System.out.println("Tên phòng ban không được để trống");
                continue;
            }

            break;
        }

        boolean result = departmentController.updateDepartment(id, newName);

        System.out.println(result ? "Update thành công" : "Update thất bại");
    }


    //  DELETE
    public void delete() {

        int id;

        while (true) {

            System.out.print("Nhập ID cần xóa: ");
            id = scanner.nextInt();

            if (id <= 0) {
                System.out.println("ID phải lớn hơn 0");
                continue;
            }

            break;
        }

        boolean result =
                departmentController.deleteDepartment(id);

        System.out.println(result ? "Xóa thành công" : "Xóa thất bại");
    }

    //  MOST EMPLOYEE
    public void mostEmployee() {

        List<Department> list = departmentController.getDepartmentHasMostEmployee();

        System.out.println("\n--- DEPARTMENT MOST EMPLOYEE ---");

        TablePrinter.printDepartmentHeader();

        for (Department d : list) {
            TablePrinter.printDepartmentRow(
                    d.getDepartmentID(),
                    d.getDepartmentName()
            );
        }

        TablePrinter.printDepartmentFooter();
    }

    // EAST EMPLOYEE
    public void leastEmployee() {

        List<Department> list = departmentController.getDepartmentHasLeastEmployee();

        System.out.println("\n--- DEPARTMENT LEAST EMPLOYEE ---");

        TablePrinter.printDepartmentHeader();

        for (Department d : list) {
            TablePrinter.printDepartmentRow(
                    d.getDepartmentID(),
                    d.getDepartmentName()
            );
        }

        TablePrinter.printDepartmentFooter();
    }

}
