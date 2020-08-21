package com.telran;

import java.util.List;
import java.util.Random;

public class StandardEmployee extends Thread {

    protected final int shortestDecisionTime;
    protected final int longestDecisionTime;
    protected final String name;
    protected final int creditsNumber;
    protected final List<Result> resultList;

    public StandardEmployee(int shortestDecisionTime, int longestDecisionTime, String name, int creditsNumber, List<Result> resultList) {
        this.shortestDecisionTime = shortestDecisionTime;
        this.longestDecisionTime = longestDecisionTime;
        this.name = name;
        this.creditsNumber = creditsNumber;
        this.resultList = resultList;
        rnd = new Random();
    }

    Random rnd;

    @Override
    public void run() {
        long startingTime = System.currentTimeMillis();
        for (int i = 0; i < creditsNumber; i++) {
            int creditTime = rnd.nextInt(longestDecisionTime - shortestDecisionTime) + shortestDecisionTime;
            try {
                Thread.sleep(creditTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endingTime = System.currentTimeMillis();
        synchronized (resultList) {
            resultList.add(new Result(name, (int) (endingTime - startingTime)));
        }
    }
}
