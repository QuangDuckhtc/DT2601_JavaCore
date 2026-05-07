package com.vti.backend;

import com.vti.entity.*;

import java.util.Scanner;

public class Exercise6 {
    Scanner sc = new Scanner(System.in);
//   question 1;
    public void question1() {

        VietnamesePhone phone = new VietnamesePhone();

        while (true) {

            System.out.println("\n========= PHONE MENU =========");
            System.out.println("1. Them contact");
            System.out.println("2. Xoa contact");
            System.out.println("3. Update contact");
            System.out.println("4. Tim kiem contact");
            System.out.println("5. Hien thi danh ba");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon: ");
            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {

                // thêm contact
                case 1:

                    System.out.print("Nhap ten: ");
                    String name = sc.nextLine();

                    System.out.print("Nhap so dien thoai: ");
                    String phoneNumber = sc.nextLine();

                    phone.insertContact(name, phoneNumber);

                    break;

                // xóa contact
                case 2:

                    System.out.print("Nhap ten can xoa: ");
                    String removeName = sc.nextLine();

                    phone.removeContact(removeName);

                    break;

                // update
                case 3:

                    System.out.print("Nhap ten can update: ");
                    String updateName = sc.nextLine();

                    System.out.print("Nhap so moi: ");
                    String newPhone = sc.nextLine();
                    phone.updateContact(updateName, newPhone);
                    break;

                // tìm kiếm
                case 4:

                    System.out.print("Nhap ten can tim: ");
                    String searchName = sc.nextLine();
                    phone.searchContact(searchName);

                    break;

                // hiển thị
                case 5:

                    System.out.println("\n===== DANH BA =====");
                    phone.showContacts();
                    break;

                // thoát
                case 6:

                    System.out.println("Thoat chuong trinh!");
                    return;

                default:
                    System.out.println("Vui long nhap lai!");
            }
        }
    }
//      question 2 and 3
public void question2And3() {

    while (true) {

        System.out.println("\n========= USER MENU =========");
        System.out.println("1. Employee");
        System.out.println("2. Manager");
        System.out.println("3. Waiter");
        System.out.println("4. Thoat");

        System.out.print("Nhap lua chon: ");
        int choose = Integer.parseInt(sc.nextLine());

        switch (choose) {

            case 1:

                System.out.print("Nhap ten Employee: ");
                String empName = sc.nextLine();

                System.out.print("Nhap salary ratio: ");
                double empRatio = Double.parseDouble(sc.nextLine());

                User employee = new Employee(empName, empRatio);

                System.out.println("\n===== THONG TIN EMPLOYEE =====");

                employee.displayInfor();

                break;

            case 2:

                System.out.print("Nhap ten Manager: ");
                String managerName = sc.nextLine();

                System.out.print("Nhap salary ratio: ");
                double managerRatio =
                        Double.parseDouble(sc.nextLine());

                User manager = new Manager(managerName, managerRatio);

                System.out.println("\n===== THONG TIN MANAGER =====");

                manager.displayInfor();

                break;

            case 3:

                System.out.print("Nhap ten Waiter: ");
                String waiterName = sc.nextLine();

                System.out.print("Nhap salary ratio: ");
                double waiterRatio =
                        Double.parseDouble(sc.nextLine());

                User waiter = new Waiter(waiterName, waiterRatio);

                System.out.println("\n===== THONG TIN WAITER =====");

                waiter.displayInfor();

                break;

            case 4:

                System.out.println("Thoat chuong trinh!");

                return;

            default:

                System.out.println("Lua chon khong hop le!");
        }
    }
}

}
