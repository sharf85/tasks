package com.telran;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<Account> isPositive = account -> account.getBalance() > 0;
        Predicate<Account> isLocked = account -> account.isBlocked();
//        Predicate<Account> isLocked = Account::isBlocked;
        Predicate<Account> isRichGuy = account -> account.getBalance() > 100_000;

        Predicate<Account> complexPredicate = isLocked.negate().and(isRichGuy);
    }
}
