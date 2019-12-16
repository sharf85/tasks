package com.telran;

import java.util.Arrays;

public class Censor {

    private String[] vocab;

    public Censor(String[] vocab) {
        this.vocab = Arrays.copyOf(vocab, vocab.length);
    }

    public boolean isLegal(String text) {
        text = text.toLowerCase();

        for (String badWord : vocab) {
            if (text.contains(badWord.toLowerCase()))
                return false;
        }

        return true;
    }
}
