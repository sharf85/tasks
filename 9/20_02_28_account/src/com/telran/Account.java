package com.telran;

public class Account {

    private String number;
    private long balance;
    private boolean isBlocked;

    public Account(String number, long balance, boolean isBlocked) {
        this.number = number;
        this.balance = balance;
        this.isBlocked = isBlocked;
    }

    public String getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }


}
