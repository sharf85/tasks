package com.telran;

import java.util.List;

public class InspiredLoanIssuer extends LoanIssuer {

    /**
     * in percents
     */
    int inspirationProbability;
    int minInspiredIssuingTime;
    int maxInspiredIssuingTime;

    public InspiredLoanIssuer(int minIssuingTime,
                              int maxIssuingTime,
                              String name,
                              List<Result> results,
                              int numCredits,
                              int inspirationProbability,
                              int minInspiredIssuingTime,
                              int maxInspiredIssuingTime) {
        super(minIssuingTime, maxIssuingTime, name, results, numCredits);
        this.inspirationProbability = inspirationProbability;
        this.minInspiredIssuingTime = minInspiredIssuingTime;
        this.maxInspiredIssuingTime = maxInspiredIssuingTime;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        int inspiredLoansLeft = 0;
        for (int i = 0; i < numCredits; i++) {

            if (inspiredLoansLeft == 0 && random.nextInt(100) < inspirationProbability)
                inspiredLoansLeft = 3;

            int timeToIssue;
            if (inspiredLoansLeft > 0) {
                inspiredLoansLeft--;
                timeToIssue = minInspiredIssuingTime + random.nextInt(maxInspiredIssuingTime - minInspiredIssuingTime);
            } else {
                timeToIssue = minIssuingTime + random.nextInt(maxIssuingTime - minIssuingTime);
            }

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
