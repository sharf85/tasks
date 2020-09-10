package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    AccountService accountService = new AccountService();

    @Test
    public void testTransactionsChecker() {
        Transaction transaction1 = new Transaction("t1", TransactionState.PROCESSING, 400);
        Transaction transaction2 = new Transaction("t2", TransactionState.CANCELLED, 500);
        Transaction transaction3 = new Transaction("t3", TransactionState.FINISHED, 600);
        Transaction transaction4 = new Transaction("t4", TransactionState.CANCELLED, 0);
        Transaction transaction5 = new Transaction("t4", TransactionState.CANCELLED, 1000);

        Account account1 = new Account("a1", 300, Arrays.asList(transaction1, transaction2));
        Account account2 = new Account("a2", 700, Arrays.asList(transaction3, transaction4, transaction5));

        assertEquals(1500, accountService.countSumCancelledTransactions(Arrays.asList(account1, account2)));
    }

    @Test
    public void testSumOfCancelledTransactions_mixedAccountsWithMixedTransactions() {
        Transaction t1 = new Transaction("1stT", TransactionState.FINISHED, 100_000);
        Transaction t2 = new Transaction("2ndT", TransactionState.CANCELLED, 1000);
        Transaction t3 = new Transaction("3rdT", TransactionState.PROCESSING, 100000);
        Transaction t4 = new Transaction("4thT", TransactionState.CANCELLED, 9000);
        Transaction t5 = new Transaction("5thT", TransactionState.FINISHED, 100000);
        Transaction t6 = new Transaction("6thT", TransactionState.CANCELLED, 100000);

        List<Transaction> client1Transactions = Arrays.asList(t1, t2);
        List<Transaction> client2Transactions = Arrays.asList(t3, t4);
        List<Transaction> client3Transactions = Arrays.asList(t5, t6);

        Account a1 = new Account("Client 1", 1000, client1Transactions);
        Account a2 = new Account("Client 2", 100_000, client2Transactions);
        Account a3 = new Account("Client 3", -100, client3Transactions);

        List<Account> accountList = Arrays.asList(a1, a2, a3);

        long actual = accountService.countSumCancelledTransactions(accountList);
        assertEquals(10000, actual);
    }

    @Test
    public void testSumOfCancelledTransactions_noCancelled_0() {
        Transaction t1 = new Transaction("1stT", TransactionState.FINISHED, 100000);
        Transaction t3 = new Transaction("3rdT", TransactionState.PROCESSING, 200000);
        Transaction t5 = new Transaction("5thT", TransactionState.FINISHED, 300000);

        List<Transaction> client1Transactions = Arrays.asList(t1);
        List<Transaction> client2Transactions = Arrays.asList(t3);
        List<Transaction> client3Transactions = Arrays.asList(t5);

        Account a1 = new Account("Client 1", 1000, client1Transactions);
        Account a2 = new Account("Client 2", 100_000, client2Transactions);
        Account a3 = new Account("Client 3", -100, client3Transactions);

        List<Account> accountList = Arrays.asList(a1, a2, a3);
        long actual = accountService.countSumCancelledTransactions(accountList);
        assertEquals(0, actual);
    }

    @Test
    public void testSumOfCancelledTransactions_noPositiveAccounts_0() {
        Transaction t1 = new Transaction("1stT", TransactionState.FINISHED, 100000);
        Transaction t2 = new Transaction("2ndT", TransactionState.CANCELLED, 1000);
        Transaction t3 = new Transaction("3rdT", TransactionState.PROCESSING, 100000);
        Transaction t4 = new Transaction("4thT", TransactionState.CANCELLED, 9000);
        Transaction t5 = new Transaction("5thT", TransactionState.FINISHED, 100000);
        Transaction t6 = new Transaction("6thT", TransactionState.CANCELLED, 100000);

        List<Transaction> client1Transactions = Arrays.asList(t1, t2);
        List<Transaction> client2Transactions = Arrays.asList(t3, t4);
        List<Transaction> client3Transactions = Arrays.asList(t5, t6);

        Account a1 = new Account("Client 1", 0, client1Transactions);
        Account a2 = new Account("Client 2", -200_000, client2Transactions);
        Account a3 = new Account("Client 3", -100, client3Transactions);

        List<Account> accountList = Arrays.asList(a1, a2, a3);
        long actual = accountService.countSumCancelledTransactions(accountList);
        assertEquals(0, actual);
    }
}
