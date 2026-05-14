package frontend;

import backend.controller.PositionController;

import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    DepartmentFunction departmentFunction = new DepartmentFunction();
    AccountFunction accountFunction = new AccountFunction();
    PositionFunction positionFunction = new PositionFunction();

    public void run (){

        while (true) {

            System.out.println("\n=========== SYSTEM MENU ===========");
            System.out.println("1. Department Function");
            System.out.println("2. Position Function");
            System.out.println("3. Account Function");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    departmentFunction.menu();
                    break;
                case 2:
                    positionFunction.menu();
                    break;

                case 3:
                    accountFunction.menu();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình!");
                    return;

                default:
                    System.out.println("Sai lựa chọn, vui lòng nhập lại!");
            }
        }
    }
}