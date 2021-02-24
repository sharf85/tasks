package de.telran.transaction;

import java.util.List;

public class AccountService {

    public long getSumAllCancelledTransactions(List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                // here we already have all the transactions related to all the accounts
                .filter(transaction -> transaction.getState() == State.CANCELLED)
                .reduce(0L, (result, transaction) -> result + transaction.getSum(), Long::sum);
//                .mapToLong(transaction -> transaction.getSum())
//                .sum();
    }
}
