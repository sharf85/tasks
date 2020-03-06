package com.telran;

public class Transaction {
    private String uuid;
    private long sum;
    private int accID;

    public Transaction(String uuid, long sum, int accID) {
        this.uuid = uuid;
        this.sum = sum;
        this.accID = accID;
    }

    public String getUuid() {
        return uuid;
    }

    public long getSum() {
        return sum;
    }

    public int getAccID() {
        return accID;
    }
}