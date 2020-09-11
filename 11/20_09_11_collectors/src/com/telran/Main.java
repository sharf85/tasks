package com.telran;

import static java.util.stream.Collectors.*;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

//        Stream<Integer> stream = Stream.of(3, 5, 2, 9);
        IntStream stream = IntStream.of(3, 5, 2, 9);

        // counts sum of squares of numbers from stream
        stream.mapToObj(value -> Integer.valueOf(value)).collect(summingInt(value -> value * value));

        // counts multiplication of squares of numbers from stream
        int res = stream.mapToObj(value -> value)
                .collect(reducing(1, (currentRes, elt) -> currentRes * elt * elt));

    }
}
