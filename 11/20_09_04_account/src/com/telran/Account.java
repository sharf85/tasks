package com.telran;

public class Account {

    String id;
    long balance;
    boolean isLocked;

    public Account(String id, long balance, boolean isLocked) {
        this.id = id;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public String getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String toString() {
        return "{" +
                "id: \"" + id + '"' +
                ", balance: " + balance +
                ", isLocked: " + isLocked +
                '}';
    }
}
