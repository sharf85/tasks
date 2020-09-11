package com.telran;

public class Transaction {

    String uuid;
    String accId;
    long sum;

    public Transaction(String uuid, String accId, long sum) {
        this.uuid = uuid;
        this.accId = accId;
        this.sum = sum;
    }

    public String getUuid() {
        return uuid;
    }

    public String getAccId() {
        return accId;
    }

    public long getSum() {
        return sum;
    }
}
