package de.telran.transaction;

public class Transaction {

    private long sum;
    private String account;

    public Transaction(long sum, String account) {
        this.sum = sum;
        this.account = account;
    }

    public long getSum() {
        return sum;
    }

    public String getAccount() {
        return account;
    }
}
