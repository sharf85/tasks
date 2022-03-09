package de.telran;

import java.util.List;

public class CreativeWorker extends Worker {

    private final int creativeMaxTime;
    private final int creativeMinTime;
    private final int creativeProbability;
    private final int creativeCreditsNumber;

    public CreativeWorker(int maxTime,
                          int minTime,
                          List<Score> scores,
                          int creditsNumber,
                          String name,
                          long startTime,
                          int creativeMaxTime,
                          int creativeMinTime,
                          int creativeProbability,
                          int creativeCreditsNumber) {
        super(maxTime, minTime, scores, creditsNumber, name, startTime);
        this.creativeMaxTime = creativeMaxTime;
        this.creativeMinTime = creativeMinTime;
        this.creativeProbability = creativeProbability;
        this.creativeCreditsNumber = creativeCreditsNumber;
    }

    @Override
    public void run() {
        int creativeCreditsLeft = 0;

        for (int i = 0; i < creditsNumber; i++) {
            if (creativeCreditsLeft == 0 && tryToInspire()) {
                creativeCreditsLeft = creativeCreditsNumber;
            }

            if (creativeCreditsLeft > 0) {
                creativeCreditsLeft--;
                issueCredit(creativeMinTime, creativeMaxTime);
            } else {
                issueCredit(minTime, maxTime);
            }
        }

        long totalTime = System.currentTimeMillis() - startTime;
        Score score = new Score(name, totalTime);
        synchronized (scores) {
            scores.add(score);
        }
    }

    private boolean tryToInspire() {
        int number = rnd.nextInt(100);
        return number < creativeProbability;
    }
}
