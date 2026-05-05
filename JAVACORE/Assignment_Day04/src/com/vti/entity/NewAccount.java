package com.vti.entity;

public class NewAccount {
    private String id;
    private String name;
    int balance;

    public NewAccount(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int credit(int amount) {
        if (amount > 0) {
            return balance += amount;
        }
        return this.balance;
    }

    public int debit(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
        return this.balance;
    }

    public void transferTo(NewAccount account, int amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            account.balance += amount;
        }
    }

    @Override
    public String toString() {
        return "NewAccount{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
