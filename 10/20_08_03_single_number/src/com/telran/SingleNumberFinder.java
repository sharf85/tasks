package com.telran;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleNumberFinder {

    /**
     * The method accepts a list which contains all the numbers with a pair except one
     *
     * @param numbers integer numbers
     * @return the number having no pair
     */
    public int find(List<Integer> numbers) {
        //first solution
//        int res = 0;
//        for (int num : numbers) {
//            res ^= num;
//        }
//        return res;

        //second solution
//        Map<Integer, Integer> occurrenceByNumber = new HashMap<>();
//
//        for (int number : numbers) {
//            occurrenceByNumber.computeIfPresent(number, (key, value) -> value + 1);
//            occurrenceByNumber.putIfAbsent(number, 1);
//        }
//
//        for (int number : occurrenceByNumber.keySet()) {
//            if (occurrenceByNumber.get(number) % 2 == 1)
//                return number;
//        }
//        return Integer.MIN_VALUE;

        //third solution
        Map<Integer, Long> occurrenceByNumber = numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        return occurrenceByNumber.keySet().stream()
                .filter(key -> occurrenceByNumber.get(key) % 2 == 1)
                .findFirst().orElseThrow();
    }
}
