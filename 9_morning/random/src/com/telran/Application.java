package com.telran;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        RandomRule minMax = new MaxMinRule(-25, 25);
        RandomGenerator generator = new RandomGenerator(minMax);

        System.out.println(Arrays.toString(generator.nextInts(10)));
    }
}
