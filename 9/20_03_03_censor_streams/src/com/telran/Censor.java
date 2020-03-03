package com.telran;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Censor {
    Set<String> badWords;

    public Censor(Collection<String> badWords) {
        this.badWords = badWords.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    public List<String> findBadWords(String text) {
        return Arrays.stream(text.split(" "))
                .map(String::toLowerCase)
                .filter(badWords::contains)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
