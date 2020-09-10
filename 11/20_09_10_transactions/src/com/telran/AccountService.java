package com.telran;

import java.util.List;
import java.util.function.Predicate;

public class AccountService {

    final private Predicate<Account> isPositiveAccount = account -> account.getBalance() > 0;
    final private Predicate<Transaction> isTransactionCancelled = tr -> tr.getState() == TransactionState.CANCELLED;

    public long countSumCancelledTransactions(List<Account> accounts) {
        return accounts.stream()
                .filter(isPositiveAccount)
                .flatMap(account -> account.getTransactions().stream())
                .filter(isTransactionCancelled)
                .mapToLong(Transaction::getSum)
                .sum();
    }
}
