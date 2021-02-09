package de.telran;

import java.util.List;
import java.util.Random;

public class Issuer implements Runnable {

    final String name;
    final int min;
    final int max;
    final int creditsNum;
    final List<Score> scores;

    public Issuer(String name, int min, int max, int creditsNum, List<Score> scores) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.creditsNum = creditsNum;
        this.scores = scores;
    }


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        issueCredits();

        int result = (int) (System.currentTimeMillis() - startTime);
        Score score = new Score(name, result);

        synchronized (scores) {
            scores.add(score);
        }
    }

    protected void issueCredits() {
        for (int i = 0; i < creditsNum; i++) {
            int issuingTime = generateIssuingTime(max, min);
            try {
                Thread.sleep(issuingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    protected Random rnd = new Random();

    protected int generateIssuingTime(int max, int min) {
        return rnd.nextInt(max - min + 1) + min;
    }
}
