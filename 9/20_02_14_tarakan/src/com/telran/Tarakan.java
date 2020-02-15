package com.telran;

import java.util.List;
import java.util.Random;

public class Tarakan implements Runnable {

    int id;
    int minTime;
    int maxTime;
    int nSteps;
    List<FinishInfo> winRate;

    Random rnd = new Random();

    public Tarakan(int id, int minTime, int maxTime, int nSteps, List<FinishInfo> winRate) {
        this.id = id;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.nSteps = nSteps;
        this.winRate = winRate;
    }

    @Override
    public void run() {
        for (int i = 0; i < nSteps; i++) {
            try {
                Thread.sleep(minTime + rnd.nextInt(maxTime - minTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        FinishInfo info = new FinishInfo(id, System.currentTimeMillis());
        winRate.add(info);
    }
}
