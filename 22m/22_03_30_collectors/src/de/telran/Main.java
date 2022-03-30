package de.telran;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        // Коллектор - это правило, следуя которому терминальный метод collect() выдает какой-дибо результат, комбинируя
        // элементы из стрима
        // 1. Collectors.toList()
        // 2. Collectors.toSet()
        // 3. Collectors.toMap(Function<T, K>, Function<T, V>)

        List<Account> accounts = Arrays.asList(
                new Account("1", 100, AccountState.ACTIVE),
                new Account("2", -1000, AccountState.BLOCKED),
                new Account("3", 5, AccountState.REMOVED),
                new Account("4", 10000, AccountState.ACTIVE),
                new Account("5", -100, AccountState.BLOCKED)
        );
        // хотим получить Map, ключами которого являются uuid, а значениями балансы

        Map<String, Long> balanceByUUID = accounts.stream()
                .collect(toMap(Account::getUuid, Account::getBalance));
        // 4. Collectors.toCollection
        List<Account> accounts2 = accounts.stream()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        // 5. Collectors.partitioningBy(Predicate<T>)

        Map<Boolean, List<Account>> partitioningByBalance = accounts.stream()
                .collect(partitioningBy((acc) -> acc.getBalance() > 0));

        System.out.println(partitioningByBalance);

        // 6. Collectors.groupingBy
        Map<AccountState, List<Account>> groupingByState = accounts.stream()
                .collect(groupingBy(Account::getState, toList()));
        System.out.println(groupingByState);

        // 7. summingInt, summingLong, summingDouble
        //averagingInt, averagingLong, averagingDouble
        //maxBy, minBy
        //counting
        System.out.println((accounts.stream().collect(counting())));

        long totalBalance = accounts.stream()
                .collect(summingLong(Account::getBalance));

        Account richestAccount = accounts.stream().max(Account::compareTo)
                .orElseThrow();
        System.out.println(richestAccount);

        double averageBalance = accounts.stream()
                .collect(averagingDouble(Account::getBalance));
        System.out.println(averageBalance);

        // 8. reducing(identity, transformer, accumulator)

        long totalBalance2 = accounts.stream()
                .collect(reducing(0L, Account::getBalance, (res, currentBalance) -> res + currentBalance));

        // Downstream collectors.
        // Некоторые коллекторы, например groupingBy и partitioningBy могут принимать коллекторы в качестве дополнительных
        // параметров (аргументов). Такие коллекторы называются downstream collectors.

        // Пример. Хотим посчитать для каждого AccountState суммарный баланс соответствующих аккаунтов.

        Map<AccountState, Long> totalBalanceByAccountState = accounts.stream()
                .collect(groupingBy(Account::getState, summingLong(Account::getBalance)));

    }
}

class Account implements Comparable<Account> {
    String uuid;
    long balance;
    AccountState state;

    @Override
    public String toString() {
        return "Account{" +
                "uuid='" + uuid + '\'' +
                ", balance=" + balance +
                ", state=" + state +
                '}';
    }

    public Account(String uuid, long balance, AccountState state) {
        this.uuid = uuid;
        this.balance = balance;
        this.state = state;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public String getUuid() {
        return uuid;
    }

    public long getBalance() {
        return balance;
    }

    public AccountState getState() {
        return state;
    }

    @Override
    public int compareTo(Account another) {
        return Long.compare(this.getBalance(), another.getBalance());
    }
}

enum AccountState {
    REMOVED, ACTIVE, BLOCKED
}
