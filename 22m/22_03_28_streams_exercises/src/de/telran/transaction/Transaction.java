package de.telran.transaction;

public class Transaction {
    String uuid;
    String state;
    long sum;
    long date;


    public Transaction(String uuid, String state, long sum, long date) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public String getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }

    public long getDate() {
        return date;
    }

    public void setState(String state) {
        this.state = state;
    }
}
