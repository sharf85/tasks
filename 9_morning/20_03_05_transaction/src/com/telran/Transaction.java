package com.telran;

public class Transaction {
    private volatile static int incrementer = 1;

    private int id;
    private State state;
    private long sum;

    public Transaction(State state, long sum) {
        synchronized (Transaction.class) {
            id = incrementer++;
        }
        this.state = state;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }
}

enum State {
    CANCELLED, FINISHED, PROCESSING
}
