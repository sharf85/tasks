package com.telran;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//        Stream<Integer> stream = Stream.of(3, 5, 2, 9);
        IntStream stream = IntStream.of(3, 5, 2, 9);

        // counts sum of squares of numbers from stream
        int sum = stream.mapToObj(value ->
                value).collect(summingInt(value -> value * value));

        // counts multiplication of squares of numbers from stream
        Collector<Integer, ?, Integer> multiplicationSqrCollector = reducing(1, (currentRes, elt) -> currentRes * elt * elt);
        int mul = stream.mapToObj(value -> Integer.valueOf(value))
                .collect(multiplicationSqrCollector);

        // collector for partitioning a stream of Strings onto the list of palindromes and all others

        Stream<String> stringStream = Stream.of("abcba", "afsafs", "aba", "ima", "pamap", "pampam", "", "a");

        Predicate<String> isPalindrome = Main::isPalindrome;
        Map<Boolean, List<String>> stringsByIsPalindrome = stringStream.collect(partitioningBy(isPalindrome));

    }

    private static boolean isPalindrome(String str) {
        return new StringBuilder(str)
                .reverse()
                .toString()
                .equals(str);
    }
}
