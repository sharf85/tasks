package com.telran;

import java.util.*;

/**
 * The class has a set of words. The method split tries to split a given text into the words
 * from the vocabulary (set of words)
 */
public class Dictionary {
    private Set<String> words;

    public Dictionary(Set<String> words) {
        this.words = words;
    }

    public Dictionary(Collection<String> words) {
        this.words = new HashSet<>(words);
    }


    /**
     * @param text to be split
     * @return a list of words which the text is split on,
     * otherwise null if the text cannot be split
     */
    public Deque<String> split(String text) {
        Deque<String> result = new ArrayDeque<>();
        return splitRecursive(text, 0, result) ? result : null;
    }

    private boolean splitRecursive(String text, int i, Deque<String> result) {
        if (i == text.length())
            return true;

        for (String word : words) {
            if (text.startsWith(word, i)) {
                result.addLast(word);
                boolean isSplit = splitRecursive(text, i + word.length(), result);
                if (isSplit)
                    return true;
                result.removeLast();
            }
        }
        return false;
    }
}
