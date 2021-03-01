package de.telran.transaction;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;

public class TransactionService {

    public Map<String, Long> getSumByAccount(List<Transaction> transactions) {
        return transactions.stream()
                .collect(groupingBy(Transaction::getAccount, summingLong(Transaction::getSum)));
    }
}
