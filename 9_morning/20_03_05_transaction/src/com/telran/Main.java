package com.telran;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Transaction tr1 = new Transaction(State.CANCELLED, 10000);
        Transaction tr2 = new Transaction(State.PROCESSING, 10000);
        Transaction tr3 = new Transaction(State.PROCESSING, 10000);
        Transaction tr4 = new Transaction(State.CANCELLED, 10000);
        Transaction tr5 = new Transaction(State.FINISHED, 10000);
        Transaction tr6 = new Transaction(State.CANCELLED, 10000);
        Transaction tr7 = new Transaction(State.FINISHED, 10000);
        Transaction tr8 = new Transaction(State.PROCESSING, 10000);
        Transaction tr9 = new Transaction(State.CANCELLED, 10000);

        Account acc1 = new Account(500, Arrays.asList(tr1, tr2, tr3));
        Account acc2 = new Account(-500, Arrays.asList(tr4, tr5, tr6));
        Account acc3 = new Account(1, Arrays.asList(tr7, tr8, tr9));

        Stream<Account> accountStream = Stream.of(acc1, acc2, acc3);

        long res = accountStream.filter(acc -> acc.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() == State.CANCELLED)
                .mapToLong(Transaction::getSum)
                .sum();

        System.out.println(res);


        long res1 = accountStream.filter(acc -> acc.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() == State.CANCELLED)
                .map(Transaction::getSum)
                .reduce(0L, Long::sum);

        System.out.println(res);
    }


}
