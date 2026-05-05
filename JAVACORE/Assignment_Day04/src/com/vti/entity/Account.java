package com.vti.entity;

import java.time.LocalDate;
import java.util.Date;

public class Account {
    private int accountID;
    private String email;
    private String userName;
    private String firstName;
    private String fullName;
    private Department department;
    private LocalDate createDate;
    private Position position;

    // a,.   tạo constructor ko tham số
    public Account() {

    }

    //   b.  tạo constructor có tham số
    public Account(int id, String email, String userName, String firstName, String lastName) {
        this.accountID = id;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.fullName = firstName + " " + lastName;
    }

    //    c.tạo constructor có tham số
    public Account(int id, String email, String userName, String firstName, String lastName, Position position) {
        this.accountID = id;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = LocalDate.now();
    }
//    d.
public Account(int id, String email, String userName, String firstName, String lastName, Position position, LocalDate createDate) {
    this.accountID = id;
    this.email = email;
    this.userName = userName;
    this.firstName = firstName;
    this.fullName = firstName + " " + lastName;
    this.position = position;
    this.createDate = createDate;
}

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", createDate=" + createDate +
                ", position=" + position +
                '}';
    }
}