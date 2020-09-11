package com.telran;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;

public class TransactionService {

    public Map<String, Long> getSumByAcc(List<Transaction> transactions) {
        return transactions.stream()
                .collect(
                        groupingBy(Transaction::getAccId,
                                summingLong(Transaction::getSum)
                        )
                );
    }
}
