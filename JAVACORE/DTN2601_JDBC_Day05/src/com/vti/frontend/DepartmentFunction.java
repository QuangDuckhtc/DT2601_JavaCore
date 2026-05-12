package com.vti.frontend;

import com.vti.backend.QLDepartment;
import com.vti.entity.Department;
import com.vti.utils.TablePrinter;

import java.util.List;
import java.util.Scanner;

public class DepartmentFunction {
    private static Scanner scanner = new Scanner(System.in);
    private static QLDepartment qlDepartment = new QLDepartment();

    // ================= MENU =================
    public static void menu() {

        while (true) {

            System.out.println("\n=========== DEPARTMENT MENU ===========");
            System.out.println("1. Hiển thị danh sách department");
            System.out.println("2. Tìm department theo ID + Name");
            System.out.println("3. Thêm department");
            System.out.println("4. Sửa department");
            System.out.println("5. Xóa department");
            System.out.println("6. Department nhiều nhân viên nhất");
            System.out.println("7. Department ít nhân viên nhất");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

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

                case 0:
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }

    //SHOW ALL
    public static void showAll() {

        List<Department> list = qlDepartment.getAllDepartments();

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
    public static void findByIdAndName() {

        System.out.print("Nhập ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập name: ");
        String name = scanner.nextLine();

        List<Department> list = qlDepartment.findByDepartmentIDAndName(id, name);

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
    public static void insert() {

        System.out.print("Nhập tên department: ");
        String name = scanner.nextLine();

        boolean result = qlDepartment.insertDepartment(name);

        System.out.println(result ? "Thêm thành công" : "Thêm thất bại");
    }

    //  UPDATE
    public static void update() {

        System.out.print("Nhập ID cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên mới: ");
        String name = scanner.nextLine();

        boolean result = qlDepartment.updateDepartment(id, name);

        System.out.println(result ? "Update thành công" : "Update thất bại");
    }

    //  DELETE
    public static void delete() {

        System.out.print("Nhập tên cần xóa: ");
        String name = scanner.nextLine();

        boolean result = qlDepartment.deleteDepartment(name);

        System.out.println(result ? "Xóa thành công" : "Xóa thất bại");
    }

    //  MOST EMPLOYEE
    public static void mostEmployee() {

        List<Department> list = qlDepartment.getDepartmentHasMostEmployee();

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
    public static void leastEmployee() {

        List<Department> list = qlDepartment.getDepartmentHasLeastEmployee();

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
