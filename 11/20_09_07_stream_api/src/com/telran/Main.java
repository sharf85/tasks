package com.telran;

import com.telran.predicate.DifferentNumbersPredicate;
import com.telran.predicate.TernaryIntPredicate;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        TernaryIntPredicate classicPredicate = new DifferentNumbersPredicate();

        System.out.println(classicPredicate.test(1, 2, 3));

        TernaryIntPredicate lambdaPredicate = (int a, int b, int c) -> {
            return a != b && b != c && c != a;
        };

        System.out.println(lambdaPredicate.test(1, 2, 3));
        System.out.println(lambdaPredicate.test(1, 2, 2));


        Function<Integer, Integer> f = (Integer x) -> {
            return x * 2;
        };

        Function<Integer, Integer> g = (Integer x) -> {
            return x + 3;
        };

//        Function<Integer, Integer> fAndGComposition = f.compose(g);
        Function<Integer, Integer> fAndGComposition = g.andThen(f);

        System.out.println(fAndGComposition.apply(3));
    }
}
