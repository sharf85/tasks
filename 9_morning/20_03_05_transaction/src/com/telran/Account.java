package com.telran;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private static AtomicInteger incrementer = new AtomicInteger();
    private int id;
    private long balance;
    private List<Transaction> transactions;

    public Account(long balance, List<Transaction> transactions) {
        this.id = incrementer.addAndGet(1);
        this.balance = balance;
        this.transactions = transactions;
    }

    public int getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
