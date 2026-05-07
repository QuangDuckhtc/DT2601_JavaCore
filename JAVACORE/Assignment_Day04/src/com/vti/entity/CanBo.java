package com.vti.entity;

public class CanBo {
    private String fullName;
    private int age;
    private String gender;
    private String address;

    public CanBo(){

    }
    public CanBo(String fullName, int age, String gender, String address) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "fullName ='" + fullName + '\'' +
                ", age =" + age +
                ", gender ='" + gender + '\'' +
                ", address ='" + address + '\'' +
                '}';
    }
}
