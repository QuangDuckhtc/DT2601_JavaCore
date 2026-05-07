package com.vti.backend;

import com.vti.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise1 {
    public void question1() {

        Scanner sc = new Scanner(System.in);

        List<News> newsList = new ArrayList<>();

        while (true) {

            System.out.println("\n========= MENU =========");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");

            System.out.print("Nhap lua chon: ");
            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {

                case 1:

                    News news = new News();

                    System.out.print("Nhap title: ");
                    news.setTitle(sc.nextLine());

                    System.out.print("Nhap publish date: ");
                    news.setPublishDate(sc.nextLine());

                    System.out.print("Nhap author: ");
                    news.setAuthor(sc.nextLine());

                    System.out.print("Nhap content: ");
                    news.setContent(sc.nextLine());
                    int[] rates = new int[3];

                    for (int i = 0; i < rates.length; i++) {

                        System.out.print("Nhap rate " + (i + 1) + ": ");
                        rates[i] = Integer.parseInt(sc.nextLine());
                    }

                    news.setRates(rates);

                    newsList.add(news);

                    System.out.println("Them news thanh cong!");

                    break;

                case 2:

                    for (News n : newsList) {
                        n.display();
                    }
                    break;

                case 3:

                    for (News n : newsList) {
                        n.calculate();
                        n.display();
                    }

                    break;

                case 4:
                    return;

                default:
                    System.out.println("Nhap sai!");
            }
        }
    }

    public void question2() {

        Scanner sc = new Scanner(System.in);

        TuyenSinh tuyenSinh = new TuyenSinh();

        while (true) {

            System.out.println("\n========= MENU =========");
            System.out.println("1. Them moi thi sinh");
            System.out.println("2. Hien thi thong tin");
            System.out.println("3. Tim kiem theo SBD");
            System.out.println("4. Thoat");

            System.out.print("Nhap lua chon: ");

            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {

                // thêm mới
                case 1:

                    System.out.println("\n===== CHON KHOI =====");
                    System.out.println("1. Khoi A");
                    System.out.println("2. Khoi B");
                    System.out.println("3. Khoi C");

                    System.out.print("Nhap khoi thi: ");

                    int khoi =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nhap so bao danh: ");
                    int sbd =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nhap ho ten: ");
                    String hoTen = sc.nextLine();

                    System.out.print("Nhap dia chi: ");
                    String diaChi = sc.nextLine();

                    System.out.print("Nhap muc uu tien: ");
                    int mucUuTien =
                            Integer.parseInt(sc.nextLine());

                    switch (khoi) {

                        case 1:

                            KhoiA a = new KhoiA(sbd, hoTen, diaChi, mucUuTien);

                            tuyenSinh.addThiSinh(a);

                            break;

                        case 2:

                            KhoiB b = new KhoiB(sbd, hoTen, diaChi, mucUuTien
                            );

                            tuyenSinh.addThiSinh(b);

                            break;

                        case 3:

                            KhoiC c = new KhoiC(sbd, hoTen, diaChi, mucUuTien);

                            tuyenSinh.addThiSinh(c);

                            break;

                        default:

                            System.out.println("Nhap sai khoi!");
                    }

                    break;

                // hiển thị
                case 2:

                    System.out.println("\n===== DANH SACH THI SINH =====");

                    tuyenSinh.showInfo();

                    break;

                // tìm kiếm
                case 3:

                    System.out.print("Nhap so bao danh can tim: ");

                    int searchSBD =
                            Integer.parseInt(sc.nextLine());

                    tuyenSinh.searchBySoBaoDanh(searchSBD);

                    break;

                // thoát
                case 4:

                    System.out.println("Thoat chuong trinh!");

                    return;

                default:

                    System.out.println("Nhap sai!");
            }
        }
    }
}