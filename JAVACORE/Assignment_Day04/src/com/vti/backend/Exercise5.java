package com.vti.backend;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;
import com.vti.entity.QLCB;

import java.util.Scanner;

public class Exercise5 {

    public void question2() {

        Scanner sc = new Scanner(System.in);

        QLCB qlcb = new QLCB();

        while (true) {

            System.out.println("\n========= MENU =========");
            System.out.println("1. Them moi can bo");
            System.out.println("2. Tim kiem can bo theo ten");
            System.out.println("3. Hien thi danh sach can bo");
            System.out.println("4. Xoa can bo theo ten");
            System.out.println("5. Thoat");

            System.out.print("Nhap lua chon: ");
            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {

                // thêm cán bộ
                case 1:

                    System.out.println("\n===== CHON LOAI CAN BO =====");
                    System.out.println("1. Cong nhan");
                    System.out.println("2. Ky su");
                    System.out.println("3. Nhan vien");

                    System.out.print("Nhap loai can bo: ");
                    int type = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhap ho ten: ");
                    String fullName = sc.nextLine();

                    System.out.print("Nhap tuoi: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhap gioi tinh: ");
                    String gender = sc.nextLine();

                    System.out.print("Nhap dia chi: ");
                    String address = sc.nextLine();

                    switch (type) {

                        // công nhân
                        case 1:

                            System.out.print("Nhap bac (1-10): ");
                            int level = Integer.parseInt(sc.nextLine());

                            CongNhan cn = new CongNhan(fullName, age, gender, address, level);

                            qlcb.addCanBo(cn);

                            System.out.println("Them Cong Nhan thanh cong!");

                            break;

                        // kỹ sư
                        case 2:

                            System.out.print("Nhap nganh dao tao: ");
                            String major = sc.nextLine();

                            KySu ks = new KySu(fullName, age, gender, address, major);

                            qlcb.addCanBo(ks);

                            System.out.println("Them Ky Su thanh cong!");

                            break;

                        // nhân viên
                        case 3:

                            System.out.print("Nhap cong viec: ");
                            String task = sc.nextLine();

                            NhanVien nv = new NhanVien(fullName, age, gender, address, task);

                            qlcb.addCanBo(nv);

                            System.out.println("Them Nhan Vien thanh cong!");

                            break;

                        default:
                            System.out.println("Loai can bo khong hop le!");
                    }

                    break;

                // tìm kiếm
                case 2:

                    System.out.print("Nhap ten can tim: ");
                    String searchName = sc.nextLine();

                    qlcb.searchByName(searchName);

                    break;

                // hiển thị danh sách
                case 3:

                    System.out.println("\n===== DANH SACH CAN BO =====");

                    qlcb.showList();

                    break;

                // xóa
                case 4:

                    System.out.print("Nhap ten can xoa: ");
                    String deleteName = sc.nextLine();

                    qlcb.deleteByName(deleteName);

                    break;

                // thoát
                case 5:

                    System.out.println("Thoat chuong trinh!");

                    return;

                default:

                    System.out.println("Vui long nhap lai!");
            }
        }
    }
}