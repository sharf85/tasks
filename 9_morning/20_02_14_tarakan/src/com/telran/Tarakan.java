package com.telran;

import java.util.List;

public class Tarakan implements Runnable {
    int id;
    int stepsNum;
    int minVelocity;
    int maxVelocity;

    List<FinishInfo> winRate;

    public Tarakan(int id, int stepsNum, int minVelocity, int maxVelocity, List<FinishInfo> winRate) {
        this.id = id;
        this.stepsNum = stepsNum;
        this.minVelocity = minVelocity;
        this.maxVelocity = maxVelocity;
        this.winRate = winRate;
    }

    @Override
    public void run() {

    }
}
