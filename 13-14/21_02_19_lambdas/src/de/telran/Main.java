package de.telran;

import java.util.ArrayList;
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
    }
}
