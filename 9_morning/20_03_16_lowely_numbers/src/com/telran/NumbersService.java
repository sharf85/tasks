package com.telran;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class NumbersService {

    /**
     * get all the numbers with max 2 repetitions of every unique digit in the specified range
     *
     * @param a the least number in the range
     * @param b the largest number in the range
     * @return List of all lovely numbers
     */
    public List<Integer> getLovelyNumbersBetween(int a, int b) {
        return IntStream.rangeClosed(a, b)
                .filter(this::isLovely)
                .boxed()
                .collect(Collectors.toList());
    }

    // 11122353 -> "11122353" -> {1,1,1,2,2,3,5,3}
    private boolean isLovely(int num) {
//        Map<Integer, Long> qtyByDigit =
//                String.valueOf(num).chars()
//                        .boxed()
//                        .collect(groupingBy(x -> x, counting()));
//        return qtyByDigit.values().stream().noneMatch(x -> x > 2);
        return String.valueOf(num).chars()
                .boxed()
                .collect(groupingBy(x -> x, counting()))
                .values()
                .stream()
                .noneMatch(x -> x > 2);

    }
}
