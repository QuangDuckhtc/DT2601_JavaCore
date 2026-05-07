package com.vti.entity;

public class CongNhan extends CanBo {
    private int level;

    public CongNhan() {

    }

    public CongNhan(String fullName, int age, String gender, String address, int level) {
        super(fullName, age, gender, address);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "fullName ='" + getFullName() + '\'' +
                ", age =" + getAge() +
                ", gender ='" + getGender() + '\'' +
                ", address ='" + getAddress() + '\'' +
                ", level =" + level +
                '}';
    }
}


