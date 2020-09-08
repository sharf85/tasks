package com.telran;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamMerge {

    IntPredicate isDividedBy3 = num -> num % 3 == 0;
    IntPredicate isDividedBy5 = num -> num % 5 == 0;
    IntPredicate isDividedBy3Or5 = isDividedBy3.or(isDividedBy5);


    public IntStream merge(IntStream stream1, IntStream stream2) {
        return IntStream.concat(stream1, stream2)
                .filter(isDividedBy3Or5)
                .sorted()
                .skip(2);
    }
}
