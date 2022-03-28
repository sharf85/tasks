package de.telran;

import de.telran.department.Department;
import de.telran.transaction.Account;
import de.telran.transaction.Transaction;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    //Написать функцию, которая определяет, является ли число простым (bolean isPrime(int number)).
    //Простое число, это такое целое число, большее 1, которое делится только на себя и 1.
    //Например, 2, 3, 5, 7, 11, 13, 17... Использовать стримы (подсказка: метод IntStream.range)
    public boolean isPrime(int p) {
        if (p < 2)
            return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(p))
                .noneMatch(num -> p % num == 0);
    }

    //Есть 2 IntStream. Сделать третий стрим, который содержит числа из обоих стримов, делящиеся на 3 и на 5.
    //Стрим должен быть отсортирован, и два первых числа должны быть пропущены
    public IntStream combine(IntStream stream1, IntStream stream2) {
        return IntStream.concat(stream1, stream2)
                .filter(x -> x % 3 == 0)
                .filter(x -> x % 5 == 0)
                .sorted()
                .skip(2);
    }

    public long factorial(int num) {
        return LongStream.rangeClosed(1, num)
                .reduce(1, (res, current) -> res * current);
    }

    // Посчитать сумму нечетных числе от a до b
    public int sumOdds(int a, int b) {
        return IntStream.rangeClosed(a, b)
                .filter(x -> x % 2 != 0)
                .sum();
    }

    //Есть class Transaction {String uuid, String state ("Cancelled", "Finished", "Processing"), long sum, long date}.
    //И есть class Account{String uuid, long balance, List<Transaction> transactions}.
    //Посчитать сумму денег всех отмененных транзакций для всех аккаунтов с балансом выше нуля.
    //Сигнатура ф-ии: long function(List<Account> accounts)
    public long sumCancelledTransactionsOfPositiveAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap((account) -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState().equals("Cancelled"))
                .mapToLong(Transaction::getSum)
                .sum();
    }

    //Есть class Employee{String name, long Salary}, class Department{String name, String code, List<Employee> employees}.
    //Посчитать общее число работников, чья зарплата >= определенного порога для всех департаментов, чей code начинается с "111-".
    //int function(List<Department> accounts, long threshold)
    public int countEmployees(List<Department> departments, long threshold, String departmentPrefix) {
        return (int) departments.stream()
                .filter(department -> department.getCode().startsWith(departmentPrefix))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }

    public void blockOligarchs(List<de.telran.account.Account> accounts, long threshold) {
        accounts.stream()
                .filter(account -> account.getSum() >= threshold)
                .forEach(account -> account.setLocked(true));
    }
}
