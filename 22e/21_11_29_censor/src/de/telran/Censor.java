package de.telran;

import java.util.Arrays;

public class Censor {

    private final String[] vocabulary;

    public Censor(String[] vocabulary) {
        this.vocabulary = Arrays.copyOf(vocabulary, vocabulary.length);
    }

    public boolean verify(String text) {
        for (int i = 0; i < vocabulary.length; i++) {
            if (text.contains(vocabulary[i]))
                return false;
        }

        return true;
    }
}
