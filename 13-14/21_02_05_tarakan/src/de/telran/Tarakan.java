package de.telran;

import java.util.List;
import java.util.Random;

public class Tarakan implements Runnable {

    final private String name;

    // number of santimeters
    final private int distance;
    final List<Score> scoreList;
    private final long startingTime;
    private final Random random = new Random();

    public Tarakan(String name, int distance, List<Score> scoreList, long startingTime) {
        this.name = name;
        this.distance = distance;
        this.scoreList = scoreList;
        this.startingTime = startingTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < distance; i++) {

            // one can introduce constants for the min and max possible running time
            int runningTime = random.nextInt(5) + 50;
            try {
                Thread.sleep(runningTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int result = (int) (System.currentTimeMillis() - startingTime);

        synchronized (scoreList) {
            scoreList.add(new Score(name, result));
        }
    }
}
