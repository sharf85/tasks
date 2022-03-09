package de.telran;

import java.util.List;
import java.util.Random;

public class Tarakan extends Thread {

    final int minStepTime;
    final int maxStepTime;
    final int distance;
    final long startTime;
    final String name;

    final List<Score> scores;
    Random rnd = new Random();

    public Tarakan(int minStepTime, int maxStepTime, int distance, long startTime, String name, List<Score> scores) {
        this.minStepTime = minStepTime;
        this.maxStepTime = maxStepTime;
        this.distance = distance;
        this.startTime = startTime;
        this.name = name;
        this.scores = scores;
    }

    @Override
    public void run() {
        for (int i = 0; i < distance; i++) {
            int stepTime = rnd.nextInt(maxStepTime - minStepTime + 1) + minStepTime;
            try {
                Thread.sleep(stepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long distanceTime = System.currentTimeMillis() - startTime;
        Score score = new Score(name, distanceTime);
        synchronized (scores) {
            scores.add(score);
        }
    }
}
