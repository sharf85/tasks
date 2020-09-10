package com.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    String uuid;
    long balance;
    List<Transaction> transactions;

    public Account(String uuid, long balance, List<Transaction> transactions) {
        this.uuid = uuid;
        this.balance = balance;
        this.transactions = new ArrayList<>(transactions);
    }

    public String getUuid() {
        return uuid;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
