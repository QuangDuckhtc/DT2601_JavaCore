package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Group {
    private int groupId;
    private String groupName;
    private Account creator;
    private LocalDate createDate;
    private Account[] accounts;

    //    a.tạo constructor ko tham số
    public Group() {


    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }

    //    b.có tham số
    public Group(String groupName, Account creator, Account[] accounts, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    //    c. có tham số
    public Group(String groupName, Account creator, String[] usernames, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;

        this.accounts = new Account[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            Account acc = new Account();
            acc.setUserName(usernames[i]);
            this.accounts[i] = acc;
        }
    }

    public int getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
}
