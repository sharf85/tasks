package de.telran.transaction;

import java.time.ZonedDateTime;

public class Transaction {

    private String uuid;
    private State state;
    private long sum;
    private ZonedDateTime time;

    public Transaction(String uuid, State state, long sum) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.time = ZonedDateTime.now();
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getUuid() {
        return uuid;
    }

    public State getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }

    public ZonedDateTime getTime() {
        return time;
    }
}
