package com.vti.frontend;

import com.vti.backend.QLAccount;
import com.vti.backend.QLDepartment;
import com.vti.backend.QLPosition;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.DButils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private  static  Scanner scanner = new Scanner(System.in);
    static void main(String[] args) {

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
                    DepartmentFunction.menu();
                    break;

                case 2:
                    PositionFunction.menu();
                    break;

                case 3:
                    AccountFunction.menu();
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
