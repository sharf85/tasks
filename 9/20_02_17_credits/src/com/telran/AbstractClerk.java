package com.telran;

import java.util.Random;

public abstract class AbstractClerk implements Runnable {

    int minTime;
    int maxTime;
    int creditsNumber;
    String name;
    long finishTime;

    Random random = new Random();

    public AbstractClerk(int minTime, int maxTime, int creditsNumber, String name) {
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.creditsNumber = creditsNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getFinishTime() {
        return finishTime;
    }
}
