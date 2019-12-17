package com.telran.tester;

public class BuilderConcatenator implements ConcatenatorInterface {
    public String concatenate(String[] strings) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
        }

        return builder.toString();
    }
}
