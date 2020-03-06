package com.telran;

public class Transaction {
    private static int incrementer;

    private int id;
    private TransactionState state;
    private long sum;

    public Transaction(TransactionState state, long sum) {
        synchronized (Transaction.class) {
            id = ++incrementer;
        }
        this.state = state;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public TransactionState getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }
}

enum TransactionState {
    CANCELLED, FINISHED, PROCESSING
}
