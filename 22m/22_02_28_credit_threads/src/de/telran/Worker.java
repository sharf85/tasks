package de.telran;

import java.util.List;
import java.util.Random;

public class Worker implements Runnable {

    protected final int maxTime;
    protected final int minTime;
    protected final List<Score> scores;
    protected final int creditsNumber;
    protected final String name;
    protected final long startTime;
    protected final Random rnd = new Random();

    public Worker(int maxTime, int minTime, List<Score> scores, int creditsNumber, String name, long startTime) {
        this.maxTime = maxTime;
        this.minTime = minTime;
        this.scores = scores;
        this.creditsNumber = creditsNumber;
        this.name = name;
        this.startTime = startTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < creditsNumber; i++) {
            issueCredit(minTime, maxTime);
        }

        long totalTime = System.currentTimeMillis() - startTime;
        Score score = new Score(name, totalTime);
        scores.add(score);
    }

    protected void issueCredit(int minTime, int maxTime) {
        int stepTime = rnd.nextInt(maxTime - minTime + 1) + minTime;
        try {
            Thread.sleep(stepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
