package de.telran.transaction;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    TransactionService transactionService = new TransactionService();

    Transaction transaction1 = new Transaction(10L, "A");
    Transaction transaction2 = new Transaction(15L, "A");
    Transaction transaction3 = new Transaction(1L, "B");
    Transaction transaction4 = new Transaction(20L, "B");

    List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3, transaction4);

    @Test
    public void sumTransactions_test() {
        Map<String, Long> result = transactionService.getSumByAccount(transactions);

        assertEquals(25L, result.get("A"));
        assertEquals(21L, result.get("B"));
    }
}
