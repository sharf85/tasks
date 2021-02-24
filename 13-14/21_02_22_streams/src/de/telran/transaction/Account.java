package de.telran.transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    private String uuid;
    private long balance;
    private List<Transaction> transactions;

    public Account(String uuid, long balance) {
        this.uuid = uuid;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getUuid() {
        return uuid;
    }

    public long getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
