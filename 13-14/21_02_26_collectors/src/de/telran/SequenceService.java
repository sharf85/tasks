package de.telran;

import java.util.List;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingLong;

public class SequenceService {

    public long sumSquared(List<Integer> numbers) {
        return numbers.stream()
                .collect(summingLong(value -> (long) value * value));
    }

    public long multiplicationSquared(List<Integer> numbers) {
        return numbers.stream()
                .collect(reducing(1L,
                        numberInt -> numberInt.longValue(),
                        (currentRes, currentNum) -> currentRes * currentNum * currentNum));
    }
}
