package de.telran.account;

public class Account {

    private String id;
    private long balance;
    private boolean isLocked;

    public Account(String id, long balance, boolean isLocked) {
        this.id = id;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
