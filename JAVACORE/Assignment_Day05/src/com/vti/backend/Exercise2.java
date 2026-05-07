package com.vti.backend;

import com.vti.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise2 {
    public void question1() {

        List<Student> students = new ArrayList<>();

        // tạo 10 học sinh
        for (int i = 0; i < 10; i++) {

            int group;
            // nhóm 1
            if (i < 3) {
                group = 1;
                // nhóm 2
            } else if (i < 6) {
                group = 2;
                // nhóm 3
            } else {
                group = 3;
            }
            Student student =
                    new Student(
                            i + 1,
                            "Student " + (i + 1),
                            group
                    );

            students.add(student);
        }

        // ================= HIEN THI DANH SACH =================
        System.out.println("===== DANH SACH STUDENT =====");

        for (Student s : students) {

            System.out.println(s);
        }

        // diem danh
        System.out.println("\n===== DIEM DANH =====");

        for (Student s : students) {

            s.diemDanh();
        }

        // nhóm 1 học bài
        System.out.println("\n===== NHOM 1 HOC BAI =====");

        for (Student s : students) {

            if (s.getGroup() == 1) {

                s.hocBai();
            }
        }
        // nhóm 2 dọn vệ sinh
        System.out.println("\n===== NHOM 2 DON VE SINH =====");

        for (Student s : students) {

            if (s.getGroup() == 2) {

                s.donVeSinh();
            }
        }
    }

    public void question2() {
        Student_q2 st = new Student_q2();

        // nhập thông tin
        st.inputInfo();

        System.out.println("\n===== THONG TIN STUDENT =====");

        // hiển thị thông tin
        st.showInfo();

        System.out.println();

        // xét học bổng
        st.hocBong();
    }

    public void question3() {

        Scanner sc = new Scanner(System.in);

        // HINH CHU NHAT
        System.out.println("===== HINH CHU NHAT =====");

        System.out.print("Nhap chieu dai: ");
        double chieuDai = sc.nextDouble();

        System.out.print("Nhap chieu rong: ");
        double chieuRong = sc.nextDouble();

        HinhChuNhat hcn =
                new HinhChuNhat(
                        chieuDai,
                        chieuRong
                );

        System.out.println("Chu vi HCN: " + hcn.tinhChuVi()
        );

        System.out.println("Dien tich HCN: " + hcn.tinhDienTich()
        );

        //  HINH VUONG
        System.out.println("\n===== HINH VUONG =====");

        System.out.print("Nhap canh: ");
        double canh = sc.nextDouble();

        HinhVuong hv = new HinhVuong(canh);

        System.out.println(
                "Chu vi HV: "
                        + hv.tinhChuVi()
        );

        System.out.println(
                "Dien tich HV: "
                        + hv.tinhDienTich()
        );
    }

    public void question4() {

        Scanner sc = new Scanner(System.in);

        MyMath math = new MyMath();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Sum int");
            System.out.println("2. Sum byte");
            System.out.println("3. Sum float");
            System.out.println("4. Exit");

            System.out.print("Nhap lua chon: ");

            int choose =
                    Integer.parseInt(sc.nextLine());

            switch (choose) {

                // int
                case 1:

                    System.out.print("Nhap a: ");
                    int intA =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nhap b: ");
                    int intB =
                            Integer.parseInt(sc.nextLine());

                    System.out.println(
                            "Tong int = "
                                    + math.sum(intA, intB)
                    );

                    break;

                // byte
                case 2:

                    System.out.print("Nhap a: ");
                    byte byteA =
                            Byte.parseByte(sc.nextLine());

                    System.out.print("Nhap b: ");
                    byte byteB =
                            Byte.parseByte(sc.nextLine());

                    System.out.println(
                            "Tong byte = "
                                    + math.sum(byteA, byteB)
                    );

                    break;

                // float
                case 3:

                    System.out.print("Nhap a: ");
                    float floatA =
                            Float.parseFloat(sc.nextLine());

                    System.out.print("Nhap b: ");
                    float floatB =
                            Float.parseFloat(sc.nextLine());

                    System.out.println(
                            "Tong float = "
                                    + math.sum(floatA, floatB)
                    );

                    break;

                // exit
                case 4:

                    System.out.println("Thoat chuong trinh!");

                    return;

                default:

                    System.out.println("Nhap sai!");
            }
        }
    }

    public void question5() {
        // điện thoại cổ điển
        DienThoaiCoDien nokia = new DienThoaiCoDien("Nokia đen trắng");

        System.out.println("===== DIEN THOAI CO DIEN =====");
        nokia.goi();

        nokia.nghe();

        nokia.guiTinNhan();

        nokia.nhanTinNhan();

        nokia.ngheRadio();

        nokia.tanCongKeXau();

        // smartphone
        DienThoaiThongMinh iphone = new DienThoaiThongMinh("Iphone 18");

        System.out.println("\n===== SMARTPHONE =====");

        iphone.goi();

        iphone.nghe();

        iphone.guiTinNhan();

        iphone.nhanTinNhan();

        iphone.suDung3G();

        iphone.chupHinh();

        iphone.tanCongKeXau();
    }
}



