package com.telran;

import java.util.*;
import java.util.stream.Collectors;

public class Censor {
    private Set<String> badWords;

    public Censor(Collection<String> badWords) {
        this.badWords = badWords.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    public List<String> findBadWords(String text) {
        String[] words = text.split(" ");
        return Arrays.stream(words)
                .map(String::toLowerCase)
                .filter(badWords::contains)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
