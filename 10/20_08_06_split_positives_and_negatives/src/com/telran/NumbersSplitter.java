package com.telran;

import java.util.List;
import java.util.stream.Collectors;

public class NumbersSplitter {

    public List<Integer> split(List<Integer> numbers) {
        List<Integer> negatives = numbers.stream()
                .filter(number -> number < 0)
                .collect(Collectors.toList());

        List<Integer> positives = numbers.stream()
                .filter(number -> number >= 0)
                .collect(Collectors.toList());

        negatives.addAll(positives);
        return negatives;
    }
}
