package com.telran;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //even size
        List<Integer> ints = Arrays.asList(-5, 10, 5, 1, 0, -3);
        Double median = ints.stream()
                .collect(new MedianElementCollector());
        System.out.println(median);

        //odd size
        List<Integer> ints2 = Arrays.asList(-5, 10, 5, 1, 0);
        Double median2 = ints2.stream()
                .collect(new MedianElementCollector());
        System.out.println(median2);
    }
}
