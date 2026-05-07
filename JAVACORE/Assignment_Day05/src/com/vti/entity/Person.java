package com.vti.entity;

import java.util.Scanner;

public class Person {
    private String name;
    private String gender;
    private String birthDay;
    private String address;


    public Person() {

    }


    public Person(String name,
                  String gender,
                  String birthDay,
                  String address) {

        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // nhập thông tin
    public void inputInfo() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten: ");
        name = sc.nextLine();

        System.out.print("Nhap gioi tinh: ");
        gender = sc.nextLine();

        System.out.print("Nhap ngay sinh: ");
        birthDay = sc.nextLine();

        System.out.print("Nhap dia chi: ");
        address = sc.nextLine();
    }

    // hiển thị thông tin
    public void showInfo() {

        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("BirthDay: " + birthDay);
        System.out.println("Address: " + address);
    }
}
