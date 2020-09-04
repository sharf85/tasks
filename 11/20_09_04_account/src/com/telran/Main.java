package com.telran;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Account acc1 = new Account("1", -1000, false);
        Account acc2 = new Account("2", 0, false);
        Account acc3 = new Account("3", 1000, true);
        Account acc4 = new Account("4", 100_001, false);
        Account acc5 = new Account("5", 100_001, true);

        List<Account> accounts = Arrays.asList(acc1, acc2, acc3, acc4, acc5);

        Predicate<Account> positive = account -> account.getBalance() > 0;
        Predicate<Account> locked = Account::isLocked;
        Predicate<Account> vip = account -> account.getBalance() > 100_000;

        AccFilter filter = new AccFilter();
        System.out.println(filter.filter(accounts, positive));

        Predicate<Account> reachPerson = locked.negate().and(vip);
        System.out.println(filter.filter(accounts, reachPerson));

    }
}
