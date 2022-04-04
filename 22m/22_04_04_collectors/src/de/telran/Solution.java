package de.telran;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Solution {
    //Есть стрим Stream<Integer>. Посчитать сумму квадратов чисел из него. (Используя коллекторы)
    public long countSumSquared(Stream<Integer> integerStream) {
//        return integerStream.collect(summingLong(number -> number * number));
        return integerStream.collect(reducing(0L, x -> (long) x, (res, current) -> res + current * current));
    }

    //Есть стрим Stream<Integer>. Посчитать произведение квадратов чисел из него. (Используя коллекторы)
    public long multiplySquared(Stream<Integer> integerStream) {
        return integerStream.collect(reducing(1L, x -> (long) x, (res, current) -> res * current * current));
    }

    //Есть лист строк.
    //Получить из него Map<Boolean, List<String>>, напротив true в котором будут собраны все палиндромы из листа,
    //а напротив false все остальное
    //получить Map<Bolean, Long>, который в качестве значений содержит количества палиндромов и непалинромов.
    protected boolean isPalindrome(String text) {
        return new StringBuilder(text).reverse().toString().equals(text);
    }

    public Map<Boolean, List<String>> groupStringsByPalindrome(List<String> strings) {
        return strings.stream()
                .collect(groupingBy(this::isPalindrome));
    }

    public Map<Boolean, Long> groupAndCountStringsByPalindrome(List<String> strings) {
        return strings.stream()
                .collect(groupingBy(this::isPalindrome, counting()));
    }

    public Map<Boolean, Integer> groupAndCountIntStringsByPalindrome(List<String> strings) {
        return strings.stream()
                .collect(groupingBy(this::isPalindrome, summingInt(str -> 1)));
    }

    //Есть class Transaction{String uuid; long sum; String accountUuid}.
    //Посчитать сумму транзакций для каждого аккаунта.
    //Map<String, Long> totalTransactionsByAccount

    public Map<String, Long> sumTransactionsByAccount(List<Transaction> transactions) {
        return transactions.stream()
                .collect(groupingBy(Transaction::getAccountUuid, summingLong(Transaction::getSum)));
    }

    //Есть class LogEntry{String login, String url}
    //1. Посчитать для каждого url, сколько раз он был тыкнут
    //*2. Посчитать количество уникальных посещений каждого url (необходимо обратить внимание на некоторые коллекторы,
    //которые не были упомянуты на занятии)
    //
    //*3. Вывести для каждого аккаунта Set посещенных страниц

    public Map<String, Long> countClicksByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, counting()));
    }

    public Map<String, Integer> countClicksIntByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, summingInt(str -> 1)));
    }

    public Map<String, Set<String>> getSetVisitedUrlsByAccount(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getLogin, mapping(LogEntry::getUrl, toSet())));
    }

    public Map<String, Integer> getNumberVisitedUrlsByAccount(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getLogin, mapping(LogEntry::getUrl, collectingAndThen(toSet(), Set::size))));
    }
}
