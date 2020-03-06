package com.telran;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        Transaction tr1 = new Transaction(TransactionState.CANCELLED, 10000);
        Transaction tr2 = new Transaction(TransactionState.FINISHED, 10000);
        Transaction tr3 = new Transaction(TransactionState.FINISHED, 10000);
        Transaction tr4 = new Transaction(TransactionState.PROCESSING, 10000);
        Transaction tr5 = new Transaction(TransactionState.CANCELLED, 10000);
        Transaction tr6 = new Transaction(TransactionState.CANCELLED, 10000);
        Transaction tr7 = new Transaction(TransactionState.FINISHED, 10000);
        Transaction tr8 = new Transaction(TransactionState.FINISHED, 10000);
        Transaction tr9 = new Transaction(TransactionState.PROCESSING, 10000);
        Transaction tr10 = new Transaction(TransactionState.CANCELLED, 10000);
        Transaction tr11 = new Transaction(TransactionState.PROCESSING, 10000);
        Transaction tr12 = new Transaction(TransactionState.CANCELLED, 10000);

        Account acc1 = new Account(1000, Arrays.asList(tr1, tr2, tr3, tr4));
        Account acc2 = new Account(1, Arrays.asList(tr5, tr6, tr7, tr8));
        Account acc3 = new Account(-1000, Arrays.asList(tr9, tr10, tr11, tr12));

        List<Account> accounts = Arrays.asList(acc1, acc2, acc3);
        long sum = accounts.stream()
                .filter(acc -> acc.getBalance() > 0)
                .flatMap(acc -> acc.getTransactions().stream())
                .filter(tr -> tr.getState() == TransactionState.CANCELLED)
                .mapToLong(Transaction::getSum)
                .sum();

        System.out.println(sum);
    }

    public static LongStream createPrimesFilteringStream(long rangeBegin, long rangeEnd) {
        return LongStream.rangeClosed(rangeBegin, rangeEnd)
                .parallel()
                .filter(num ->
                        LongStream.rangeClosed(2, (long) Math.sqrt(num))
                                .noneMatch(divider -> num % divider == 0)
                );
    }
}
