package com.telran;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(-5, 10, 2, 5, 6, -2);

        double median = ints.stream()
                .collect(new MedianCollector());
        System.out.println(median);

        List<Integer> ints1 = Arrays.asList(-5, 10, 2, 5, 6);

        double median1 = ints1.stream()
                .collect(new MedianCollector());
        System.out.println(median1);
    }
}
