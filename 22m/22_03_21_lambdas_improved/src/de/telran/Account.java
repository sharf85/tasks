package de.telran;

public class Account {

    private final int id;
    private double balance;
    private boolean isLocked;

    @Override
    public String toString() {
        return "{ Account " +
                id +
                ", balance=" + balance +
                ", isLocked=" + isLocked
                + " }";
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Account(int id, double balance, boolean isLocked) {
        this.id = id;
        this.balance = balance;
        this.isLocked = isLocked;
    }
}

