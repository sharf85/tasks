package com.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Vasya", "Vasyok", "Vasily");
        System.out.println(concatFromLongStrings(strings));


        List<String> shortStrings =
                new ArrayList<>(Arrays.asList("I", "am", "a", "great", "person"));

        Stream<String> stream = shortStrings.stream()
                .filter(str -> str.length() < 4);

//        System.out.println(stream.count());
        shortStrings.add("ya");
        shortStrings.add("!");

        System.out.println(stream.count());

    }

    static String concatFromLongStrings(Collection<String> strings) {
        return strings.stream()
                .filter(str -> str.length() > 5)
                .map(String::toLowerCase)
                .reduce((currentRes, currentElt) -> currentRes.concat(currentElt))
                .orElse("");
    }
}
