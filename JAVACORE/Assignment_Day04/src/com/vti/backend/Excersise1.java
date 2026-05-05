package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Group;

import java.time.LocalDate;

public class Excersise1 {
    // question1 : làm ở package entity
//    question2: làm ở package entity
    public  void question3() {
        Account creator = new Account();
        creator.setUserName("Admin");

        // usernames
        String[] usernames = {"test1", "test2", "test3"};

        // date
        LocalDate date = LocalDate.now();

        // tạo Group bằng constructor (c)
        Group g = new Group("Java Group", creator, usernames, date);

        // in kết quả
        System.out.println("===== GROUP TEST =====");
        System.out.println("Group name: Java Group");
        System.out.println("Creator: " + creator.getUserName());
        System.out.println("Create date: " + date);

        System.out.println("Accounts:");
        for (Account acc : g.getAccounts()) {
            System.out.println(" - " + acc.getUserName());
        }
    }
}
