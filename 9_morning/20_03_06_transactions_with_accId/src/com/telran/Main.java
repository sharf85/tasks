package com.telran;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class Main {

    public static void main(String[] args) {
        Transaction t1 = new Transaction("1234", 12000, 123);
        Transaction t2 = new Transaction("1234", 12000, 123);
        Transaction t3 = new Transaction("1234", 12000, 123);
        Transaction t4 = new Transaction("3456", 12000, 124);
        Transaction t5 = new Transaction("3456", 12000, 124);
        Transaction t6 = new Transaction("3456", 12000, 125);
        Transaction t7 = new Transaction("1234", 12000, 126);

        Stream<Transaction> transactionStream = Stream.of(t1, t2, t3, t4, t5, t6, t7);
        Map<Integer, Long> sumByAccId =

                transactionStream
                        .collect(groupingBy(Transaction::getAccID,
                                reducing(0L, Transaction::getSum, (curRes, curElt) -> curRes + curElt)));

        System.out.println(sumByAccId);
    }
}
