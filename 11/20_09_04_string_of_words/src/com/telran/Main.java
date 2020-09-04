package com.telran;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("param", "pam", "van", "Jean", "cloDT", "Van", "Damm");

        String concatenated = words.stream()
                .filter(str -> str.length() < 4)
                .map(str -> str.toUpperCase())
                .distinct()
                .reduce("", (oldRes, currentStr) -> oldRes + " " + currentStr);
        System.out.println(concatenated);
    }
}
