package com.vti.backend;

import com.vti.entity.Circle;
import com.vti.entity.Date;
import com.vti.entity.NewAccount;
import com.vti.entity.Student;

import java.util.Scanner;

public class Excercise4 {
    public float score;
    public float scorePlus;
    public double radius;
    public String color;
    Scanner sc = new Scanner(System.in);

    public void question1 (){
        float score;
        float scorePlus;
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student("Duc", "B1");

        System.out.println("==================Question 1====================");
        System.out.println("Mời bạn nhập diem: ");
        score = sc.nextFloat();
        System.out.println("Nhập điểm bổ sung: ");
        scorePlus = sc.nextFloat();
        s1.setScore(score);
        s1.addScore(scorePlus);
        s1.showInfoStudent();
    }
    public void question2(){
        double radius;
        String color;
        Scanner sc = new Scanner(System.in);
        System.out.println("==================Question 2====================");
        Circle c = new Circle();

        System.out.println("Moi ban nhap ban kinh: ");
        radius = sc.nextDouble();
        sc.nextLine();
        System.out.println("Moi ban nhap mau: ");
        color = sc.nextLine();
        c.setColor(color);
        c.setRadius(radius);

        System.out.println("Dien tich hinh tron la: " + c.getArea());
        System.out.println(c.toString());

//        account
        int amount;
        int balance;

        NewAccount newacc = new NewAccount("1", "QuangDuc", 500);
        System.out.println("Số tiền hiện tại là: " + newacc.getBalance());
        System.out.println("Moi ban nhap so tien giao dich: ");
        amount = sc.nextInt();
        System.out.println("Số tiền sau khi nạp: " + newacc.credit(amount));
        System.out.println("Số tiền sau khi rút: " + newacc.debit(amount));

//date
        Date d = new Date(20, 11, 1998);
        int year;
        System.out.println("Mời bạn nhập năm : ");
        year = sc.nextInt();

        System.out.println("là năm nhuận ko : " + d.isLeapYear(year));
        System.out.println(d.toString());
    }
}
