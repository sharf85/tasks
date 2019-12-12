package com.telran;

public class StringBuilderConcatenator implements ConcatTextInterface {
    public String concatenate(String[] texts) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < texts.length; i++) {
            builder.append(texts[i]);
        }
        return builder.toString();
    }
}
