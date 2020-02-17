package com.telran;

import java.util.Random;

public abstract class AbstractClerk implements Runnable {

    protected String name;
    protected int minTime;
    protected int maxTime;
    protected int creditsNum;
    protected long finishTime;

    protected Random random = new Random();


    public AbstractClerk(String name, int minTime, int maxTime, int creditsNum) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.creditsNum = creditsNum;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public String getName() {
        return name;
    }
}
