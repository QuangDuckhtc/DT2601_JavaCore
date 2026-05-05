package com.vti.entity;

public class Student {
    //   a. tạo class
    private int property;
    private String name;
    private String hometown;
    private float diem;

    //b. tạo constructor khi khởi tạo mỗi student thì người dùng sẽ nhập vào tên , hometown, và có điểm học lực bằng ko
    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.diem = 0;

    }

    //    c. tao method set diem
    public void setScore(float diem) {
        this.diem = diem;
    }

//    d. Tạo 1 method cho phép cộng thêm điểm
    public void addScore(float plusScore) {
        this.diem += plusScore;
    }
//e.
    public void showInfoStudent() {
        String rank;
        if (diem < 4.0) {
            rank = "Yếu";
        } else if (diem < 6.0) {
            rank = "Trung bình";
        } else if (diem < 8.0) {
            rank = "Khá";
        } else {
            rank = "Giỏi";
        }
        System.out.println("Name: " + name);
        System.out.println("Hometown: " + hometown);
        System.out.println("Score: " + diem);
        System.out.println("rank: " + rank);

    }
}
