package de.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

    static String GREETINGS = "Hello";

    public static void main(String[] args) {
        // Method reference (ссылка на метод) - это реализация функционального интерфейса,
        // используя функциональность существующего метода

        Function<Double, Double> sqrt = Math::sqrt;

        Function<Double, Double> sqrt2 = sqrt::apply;

        Supplier<String> generator = String::new;

        Function<String, String> identity = String::new;

        // closure (замукание) - возможность использовать переменные из контекста (области видимости)
        // в лямбда выражении

        // локальная переменная должна быть либо final, либо технически final
        final String greetings = "Hello ";

        Function<String, String> hello = (String name) -> greetings + name;

        // функциональные интерфейсы, встроенные в библиотеку Java:
        // семейство Functions - интерфейсы с методом apply, который что-то принимает и что-то возвращает
        // семейство Operators - интерфейсы, которые что-то принимают и что-то возвращают, при этом тип
        // всех аргументов и возвращаемой ссылки одинаковый
        // семейство Predicates - принимают что-угодно, возвращают boolean (мотод, который реализуется, называется
        // test)
        // семейство Suppliers - ничего не принимают, возвращают что-то (метод называется get())
        // семейство Consumers - что-то принимают, ничего не возвращают (метод называется accept(...))

        // printer - принимает строку и распечатывает в консоль
        Consumer<String> printer = System.out::println;
        printer.accept("Hello 22 group");
        IntPredicate isEven = x -> x % 2 == 0;

        // 1. IntSupplier                              4. Math::sin
        // 2. Consumer<String>                         1. () -> 3
        // 3. BiPredicate<Integer, Integer>            5. (x) -> String.valueOf(x)
        // 4. DoubleUnaryOperator                      2. System.out::println
        // 5. Function<Double, String>                 3. (x, x) -> x % 5 == 0

        // Композиция функций.
        // f(x) = x^2 + 3x + 5. f(1) = 1 + 3 + 5 = 9
        // g(x) = 3x - 7. f(2) = 6 - 7 = -1
        // h(x) = f(g(x)). h(x) = f(3x - 7) = (3x - 7)^2 + 3(3x - 7) + 5 = 9x^2 - 42x + 49 + 9x - 21 + 5 = 9x^2 - 33x + 33
        // h(3) = 81 - 99 + 33 = 15

        Function<Double, Double> f = x -> x * x + 3 * x + 5;
        Function<Double, Double> g = x -> 3 * x - 7;
        Function<Double, Double> h = f.compose(g);
        Function<Double, Double> anotherH = g.andThen(f);
        System.out.println(h.apply(3.0));//15
        System.out.println(anotherH.apply(3.0));//15

        Function<String, Double> f1 = Double::valueOf;//f.apply("125") -> 125.0
        Function<Integer, String> g1 = String::valueOf;// g.apply(239) -> "239"
        Function<Integer, Double> h1 = f1.compose(g1);// h.apply(38) ~ f.apply(g.apply(38)) -> 38.0

        System.out.println(38);

        // метод g.andThen(f) = f.compose(g)

        // Предикаты. Есть три default метода: and, or, negate

        IntPredicate isOdd = x -> x % 2 != 0;
        IntPredicate dividedBy3 = x -> x % 3 == 0;

        IntPredicate isOddAndDividedBy3 = isOdd.and(dividedBy3);
        IntPredicate isEvenOrDividedBy3 = isOdd.negate().or(dividedBy3);

        // 1.Используя замыкание, написать Function<Double, Double>, которая считает ax^2 + bx + c
        int a = 1;
        int b = 2;
        int c = 1;
        Function<Double, Double> f2 = x -> a * x * x + b * x + c;

        System.out.println(f2.apply(2d));

        // 2. Есть класс Account, у него есть поля int id, double balance, bool isLocked. Написать два лямбда выражения
        // Function<List<Account>, List<Account>>,
        // a) отфильтровывает аккаунты таким образом, что остаются только аккаунты с положительным баллансом;
        // b) все незаблокированные аккаунты с балансом более 100000.
        List<Account> accounts = Arrays.asList(
                new Account(1, 2000, false),
                new Account(2, 120000, true),
                new Account(3, 110000, false),
                new Account(4, -120, false)
        );
        Predicate<Account> isPositiveBalance = (account) -> account.getBalance() > 0;
        Predicate<Account> isOligarch = (account) -> !account.isLocked() && account.getBalance() > 100000;

        Function<List<Account>, List<Account>> positiveAccountFilter = (accountList) -> {
            List<Account> res = new ArrayList<>();
            for (Account account : accountList) {
                if (isPositiveBalance.test(account))
                    res.add(account);
            }
            return res;
        };

        Function<List<Account>, List<Account>> oligarchAccountFilter = (accountList) -> {
            List<Account> res = new ArrayList<>();
            for (Account account : accountList) {
                if (isOligarch.test(account))
                    res.add(account);
            }
            return res;
        };

        System.out.println(positiveAccountFilter.apply(accounts));
        System.out.println(oligarchAccountFilter.apply(accounts));

        List<Account> positiveBalanceAccounts = accounts.stream()
                .filter(isPositiveBalance)
                .collect(Collectors.toList());

        List<Account> oligarchAccounts = accounts.stream()
                .filter(isOligarch)
                .collect(Collectors.toList());

        System.out.println(positiveBalanceAccounts);
        System.out.println(oligarchAccounts);

        // 3. Написать интерфейс TernaryIntPredicate с методом bool test(int a, int b, int c). Написать лямбда выражение,
        // которое вернет true, если все аргументы различны.
        TernaryIntPredicate pairwiseDistinct = (num1, num2, num3) -> num1 != num2 && num2 != num3 && num1 != num3;

        System.out.println(pairwiseDistinct.test(1, 2, 3));//true
        System.out.println(pairwiseDistinct.test(1, 2, 2));//false

        // 4. Написать функцию, которая считает <2x> и функцию, которая считает <x + 3>. Написать функцию,
        // которая будет композицией первых двух.

        Function<Double, Double> func1 = x -> 2 * x;
        Function<Double, Double> func2 = x -> x + 3;
        Function<Double, Double> func3 = func1.compose(func2);

        System.out.println(func3.apply(10d));//26

        // 5. Написать класс PredicateService и методы в нем intersect и union, которые принимают лист предикатов,
        // а возвращают их пересечение и объединение соответственно. Протестировать.

        PredicateService predicateService = new PredicateService();

        List<Predicate<Integer>> predicates = Arrays.asList(x -> x % 2 == 0, x -> x % 4 == 0);

        Predicate<Integer> result1 = predicateService.intersect(predicates);
        Predicate<Integer> result2 = predicateService.union(predicates);

        System.out.println("Predicate Service - intersect");
        System.out.println(result1.test(2)); // false
        System.out.println(result1.test(4)); // true
        System.out.println("Predicate service - union");
        System.out.println(result2.test(2)); // true
        System.out.println(result2.test(4)); // true
        System.out.println(result2.test(3)); // false
    }
}
