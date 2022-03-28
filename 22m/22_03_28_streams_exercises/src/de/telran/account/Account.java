package de.telran.account;

public class Account {

    String uuid;
    long sum;
    boolean isLocked;

    public Account(String uuid, long sum, boolean isLocked) {
        this.uuid = uuid;
        this.sum = sum;
        this.isLocked = isLocked;
    }

    public String getUuid() {
        return uuid;
    }

    public long getSum() {
        return sum;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
