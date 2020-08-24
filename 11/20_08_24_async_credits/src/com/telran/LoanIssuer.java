package com.telran;

import java.util.List;
import java.util.Random;

public class LoanIssuer extends Thread {

    int minIssuingTime;
    int maxIssuingTime;
    String name;
    final List<Result> results;
    int numCredits;

    public LoanIssuer(int minIssuingTime,
                      int maxIssuingTime,
                      String name,
                      List<Result> results,
                      int numCredits) {
        this.minIssuingTime = minIssuingTime;
        this.maxIssuingTime = maxIssuingTime;
        this.name = name;
        this.results = results;
        this.numCredits = numCredits;
    }

    Random random = new Random();

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numCredits; i++) {
            int timeToIssue = minIssuingTime + random.nextInt(maxIssuingTime - minIssuingTime);
            try {
                Thread.sleep(timeToIssue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        synchronized (results) {
            results.add(new Result(name, (int) (endTime - startTime)));
        }
    }
}
