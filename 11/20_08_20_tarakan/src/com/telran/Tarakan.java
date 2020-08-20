package com.telran;

import java.util.List;
import java.util.Random;

public class Tarakan implements Runnable {

    private static final int FASTEST_STEP = 50;
    private static final int LONGEST_STEP = 100;

    int stepsNum;
    String name;
    List<Score> scores;
    Random random = new Random();

    public Tarakan(int stepsNum, String name, List<Score> scores) {
        this.stepsNum = stepsNum;
        this.name = name;
        this.scores = scores;
    }

    @Override
    public void run() {

    }
}
