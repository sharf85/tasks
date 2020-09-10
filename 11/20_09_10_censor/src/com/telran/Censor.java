package com.telran;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Censor {

    private Set<String> vocab;

    public Censor(Set<String> vocab) {
//        this.vocab = vocab;
        this.vocab = vocab.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    public List<String> filter(String text) {
        String[] words = text.split(" ");

        return Arrays.stream(words)
                .map(String::toLowerCase)
                .filter(word -> vocab.contains(word))
                .collect(Collectors.toList());
    }
}
