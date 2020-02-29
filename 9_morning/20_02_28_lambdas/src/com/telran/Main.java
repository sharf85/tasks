package com.telran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // lambda which leaves only distinct elements in a list.
        // Creates a new instance.
        Function<List<String>, List<String>> distinctFilter =
                (List<String> list) -> new ArrayList<>(new HashSet<>(list));

        Function<List<String>, List<String>> distinctFilterStream =
                list -> list
                        .stream()
                        .distinct()
                        .collect(Collectors.toList());

        //write lambda with closures
        final int a = 10;
        int b = 15;
        final int c = 8;

        Function<Integer, Integer> f = x -> a * x * x + b * x + c;

        TernaryPredicate isDistinct = (o1, o2, o3) -> !o1.equals(o2) && !o1.equals(o3) && !o2.equals(o3);

        System.out.println(isDistinct.test(1, 2, 3));
    }

    static <T> Predicate<T> composeDisjunctivePredicate(List<Predicate<T>> predicates) {
        Predicate<T> res = (t) -> false;
        for (Predicate<T> predicate : predicates) {
            res = res.or(predicate);
        }
        return res;
    }

}
