package com.telran;

import java.util.List;
import java.util.Random;

public class Tarakan implements Runnable {
    private int id;
    private int stepsNum;
    private int minTime;
    private int maxTime;

    private List<FinishInfo> winRate;

    private Random rnd = new Random();

    public Tarakan(int id, int stepsNum, int minTime, int maxTime, List<FinishInfo> winRate) {
        this.id = id;
        this.stepsNum = stepsNum;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.winRate = winRate;
    }

    @Override
    public void run() {
        for (int i = 0; i < stepsNum; i++) {
            try {
                Thread.sleep(minTime + rnd.nextInt(maxTime - minTime));
            } catch (InterruptedException e) {
                return;
            }
        }
        winRate.add(new FinishInfo(id, System.currentTimeMillis()));
    }
}
