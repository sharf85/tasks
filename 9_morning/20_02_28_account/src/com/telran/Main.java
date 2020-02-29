package com.telran;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<Account> isLargerThan0 = account -> account.getBalance() > 0;
        Predicate<Account> isLocked = account -> account.isLocked();

        Predicate<Account> isPositiveAndNonLocked = isLargerThan0.and(isLocked.negate());
    }
}
