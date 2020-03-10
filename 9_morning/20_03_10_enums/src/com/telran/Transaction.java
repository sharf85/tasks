package com.telran;

import java.time.ZonedDateTime;

public class Transaction {

    private TransactionState state;

    private long sum;

    private ZonedDateTime time;

    public TransactionState getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public String getStateName() {
        return state.toString();
    }
}
