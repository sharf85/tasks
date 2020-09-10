package com.telran;

public class Transaction {
    private final String uuid;
    private final TransactionState state;
    private final long sum;
    private final long createdAt;

    public Transaction(String uuid, TransactionState state, long sum) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.createdAt = System.currentTimeMillis();
    }

    public String getUuid() {
        return uuid;
    }

    public TransactionState getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
