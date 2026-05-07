package com.vti.entity;

import java.util.Scanner;

public class Student_q2 extends Person{
    private String studentId;
    private double avgScore;
    private String email;


    public Student_q2() {

    }


    public Student_q2 (String name,
                   String gender,
                   String birthDay,
                   String address,
                   String studentId,
                   double avgScore,
                   String email) {

        super(name, gender, birthDay, address);

        this.studentId = studentId;
        this.avgScore = avgScore;
        this.email = email;
    }

    // getter setter
    public String getStudentId() {
        return studentId;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public String getEmail() {
        return email;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // override nhập thông tin
    @Override
    public void inputInfo() {

        // nhập thông tin person trước
        super.inputInfo();

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma sinh vien: ");
        studentId = sc.nextLine();

        System.out.print("Nhap diem trung binh: ");
        avgScore = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap email: ");
        email = sc.nextLine();
    }

    // override hiển thị
    @Override
    public void showInfo() {

        // hiển thị person trước
        super.showInfo();

        System.out.println("Student ID: " + studentId);
        System.out.println("Average Score: " + avgScore);
        System.out.println("Email: " + email);
    }

    // xét học bổng
    public void hocBong() {

        if (avgScore >= 8) {

            System.out.println("Sinh vien duoc hoc bong");

        } else {

            System.out.println("Sinh vien khong duoc hoc bong");
        }
    }
}
