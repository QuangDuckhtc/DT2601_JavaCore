package com.vti.entity;

public class NhanVien extends CanBo {
    private String task;

    public NhanVien(String task) {
        this.task = task;
    }

    public NhanVien(String fullName, int age, String gender, String address, String task) {
        super(fullName, age, gender, address);
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


    @Override
    public String toString() {
        return "NhanVien{" +
                "fullName ='" + getFullName() + '\'' +
                ", age =" + getAge() +
                ", gender ='" + getGender() + '\'' +
                ", address ='" + getAddress() + '\'' +
                ", task ='" + task + '\'' +
                '}';
    }
}
