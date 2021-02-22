package de.telran;

import de.telran.account.Account;
import de.telran.function.TernaryIntPredicate;
import de.telran.function.UniqNumbersPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // 1)
        Function<List<String>, List<String>> removeDuplicated = (list) -> new ArrayList<>(new HashSet<>(list));

        // 2)
        int a = 5;
        int b = -2;
        int c = 8;

        Function<Double, Double> f = x -> a * x * x + b * x + c;

        // 3)
        IntSupplier supplier = () -> 3;
        Consumer<String> consumer = System.out::println;
        BiPredicate<Integer, Integer> predicate = (x, y) -> x % y == 0;
        DoubleUnaryOperator operator = Math::sin;
        Function<Double, String> function = x -> String.valueOf(x * x);

        String reduced = Stream.of("cat", "dog", "human")
                .reduce((String accumulatedString, String currentItem) -> accumulatedString + currentItem).get();
        System.out.println(reduced);

        // 4) Account - also see 'AccountTest'
        Predicate<Account> positiveBalance = account -> account.getBalance() > 0;
        Predicate<Account> majorPredicate = account -> account.getBalance() > 100_000 && !account.isLocked();

        // 5) TernaryIntPredicate
        TernaryIntPredicate explicitUniqNumbersPredicate = new UniqNumbersPredicate();
        System.out.println(explicitUniqNumbersPredicate.test(1, 2, 3));// true
        System.out.println(explicitUniqNumbersPredicate.test(1, 2, 2));// false

        TernaryIntPredicate implicitUniqNumbersPredicate = (x, y, z) -> x != y && y != z && x != z;
        System.out.println(implicitUniqNumbersPredicate.test(1, 2, 3));// true
        System.out.println(implicitUniqNumbersPredicate.test(1, 2, 2));// false

        // 6)
        // f(x) = 2*x
        // g(x) = x + 3
        // h(x) = f(g(x)) = 2(g(x)) = 2*(x + 3) = 2*x + 6
        Function<Double, Double> f1 = x -> 2 * x;
        Function<Double, Double> g1 = x -> x + 3;

        Function<Double, Double> h = f1.compose(g1);

        System.out.println(h.apply(1d));// 8
        System.out.println(h.apply(0.5));// 7
        System.out.println(h.apply(-0.5));// 5
        System.out.println(h.apply(0d));// 6

        // 7) Predicates intersection - see PredicateService

        PredicateService predicateService = new PredicateService();
        Predicate<Double> x1 = (x -> x % 2 == 0);
        Predicate<Double> y1 = (x -> x % 3 == 0);
        Predicate<Double> z1 = (x -> x < 20);
        Predicate<Double> k1 = (x -> x > 10);
        List<Predicate<Double>> list = Arrays.asList(x1, y1, z1, k1);
        System.out.println(predicateService.intersect(list).test(12d));
        System.out.println(predicateService.intersect(list).test(14d));
    }
}
