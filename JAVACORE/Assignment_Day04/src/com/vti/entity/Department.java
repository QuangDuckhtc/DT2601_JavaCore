package com.vti.entity;

public class Department {
    private int departmentID;
    private String departmentName;

    public Department(){

    }
    public Department(String name ){
        this.departmentID = 0 ;
        this.departmentName = name;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
