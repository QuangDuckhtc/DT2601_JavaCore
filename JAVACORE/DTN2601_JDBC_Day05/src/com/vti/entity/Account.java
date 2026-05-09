package com.vti.entity;

import java.time.LocalDate;

public class Account {
    private int accountID;
    private String email;
    private String fullName;
    private Department department;
    private PositionName positionName;
    private LocalDate createDate;

    public Account(){

    }
    public Account(int accountID, String email, String fullName, Department department, PositionName positionName, LocalDate createDate) {
        this.accountID = accountID;
        this.email = email;
        this.fullName = fullName;
        this.department = department;
        this.positionName = positionName;
        this.createDate = createDate;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", positionName=" + positionName +
                ", createDate=" + createDate +
                '}';
    }
}
