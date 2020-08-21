package com.telran;

import java.util.List;

public class LazyInspiredEmployee extends StandardEmployee {
    int inspiredShortest;
    int inspiredLongest;
    int inspirationProbability;

    public LazyInspiredEmployee(int shortestDecisionTime,
                                int longestDecisionTime,
                                String name,
                                int creditsNumber,
                                List<Result> resultList,
                                int inspiredShortest,
                                int inspiredLongest,
                                int inspirationProbability) {
        super(shortestDecisionTime, longestDecisionTime, name, creditsNumber, resultList);
        this.inspiredShortest = inspiredShortest;
        this.inspiredLongest = inspiredLongest;
        this.inspirationProbability = inspirationProbability;
    }


    @Override
    public void run() {
        long startingTime = System.currentTimeMillis();

        int inspiredCreditsLeft = 0;
        for (int i = 0; i < creditsNumber; i++) {
            int creditTime;

            if (inspiredCreditsLeft == 0 && rnd.nextInt(100) < inspirationProbability)
                inspiredCreditsLeft = 3;

            if (inspiredCreditsLeft > 0) {
                creditTime = rnd.nextInt(inspiredLongest - inspiredShortest) + inspiredShortest;
                inspiredCreditsLeft--;
            } else {
                creditTime = rnd.nextInt(longestDecisionTime - shortestDecisionTime) + shortestDecisionTime;
            }

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
