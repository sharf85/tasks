package com.telran;

public class Score {

    private final String name;
    private final int result;

    public Score(String name, int result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }
}
