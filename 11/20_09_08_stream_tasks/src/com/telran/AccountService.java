package com.telran;

import java.util.List;

public class AccountService {

    public void lockAccountOverLimit(List<Account> accounts, long limit) {
        accounts.stream()
                .filter(account -> account.getSum() > limit)
                .forEach(account -> account.setLocked(true));
    }

    public long sumLockedAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(Account::isLocked)
                .mapToLong(Account::getSum)
                .sum();
    }

}
