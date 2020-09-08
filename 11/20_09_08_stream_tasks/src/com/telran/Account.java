package com.telran;

public class Account {

    public Account(String id, long sum) {
        this.id = id;
        this.sum = sum;
    }

    String id;
    long sum;
    boolean isLocked;

    public String getId() {
        return id;
    }

    public long getSum() {
        return sum;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
