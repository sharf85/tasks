package de.telran;

public class Transaction {
    String uuid;
    long sum;
    String accountUuid;

    public Transaction(String uuid, long sum, String accountUuid) {
        this.uuid = uuid;
        this.sum = sum;
        this.accountUuid = accountUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public long getSum() {
        return sum;
    }

    public String getAccountUuid() {
        return accountUuid;
    }
}
