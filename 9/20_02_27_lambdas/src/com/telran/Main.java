package com.telran;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        // leave only unique elements
        Function<List<String>, List<String>> uniquesFilter = (list)
                -> new ArrayList<>(new HashSet<>(list));

        List<String> list = Arrays.asList("a", "aa", "ab", "a", "abc", "ab");
        uniquesFilter.apply(list).forEach(System.out::println);

        // closure example

        int a = 1;
        int b = 3;
        int c = 5;

        Function<Double, Double> f = x -> a * x * x + b * x + c;
        System.out.println(f.apply(10d));

        // geometric progression - multiply all numbers between a and b

        BiFunction<Integer, Integer, Integer> mul = (x, y) -> {
            int res = 1;
            for (int num = x; num <= y; num++) {
                res *= num;
            }
            return res;
        };

        System.out.println(mul.apply(1, 4));

    }

    public static <T> Predicate<T> disjunction(List<Predicate<T>> predicates) {
        Predicate<T> res = t -> false;
        for (Predicate<T> predicate : predicates) {
            res = res.or(predicate);
        }
        return res;
    }
}
