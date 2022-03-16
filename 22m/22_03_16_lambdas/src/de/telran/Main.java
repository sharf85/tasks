package de.telran;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> summarizer = (Integer x, Integer y) -> x + y;

        System.out.println(summarizer.apply(10, 5));

        print1(input -> input, "Vasya");

        print2((String input) -> {
            return input;
        }, "Vasya");
    }

    public static void print1(OurFunctionalInterface ourFunctionalInterface, String line) {
        System.out.println(ourFunctionalInterface.print(line));
    }

    public static void print2(AnotherFunctionalInterface ourFunctionalInterface, String line) {
        System.out.println(ourFunctionalInterface.some(line));
    }
}

interface OurFunctionalInterface {
    public String print(String line);
}

interface AnotherFunctionalInterface {
    public String some(String line);
}
