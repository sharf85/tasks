package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static final int PARTICIPANTS_NUMBER = 10;
    static final int DISTANCE = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread[] tarakanThreads = new Thread[PARTICIPANTS_NUMBER];
        List<Score> results = new ArrayList<>();
        long startingTime = System.currentTimeMillis();

        for (int i = 0; i < PARTICIPANTS_NUMBER; i++) {
            tarakanThreads[i] = new Thread(new Tarakan("Tarakan" + i, DISTANCE, results, startingTime));
        }

        for (int i = 0; i < PARTICIPANTS_NUMBER; i++) {
            tarakanThreads[i].start();
        }

        // waiting for ll the tarakans finish
        for (int i = 0; i < PARTICIPANTS_NUMBER; i++) {
            tarakanThreads[i].join();
        }

        int i = 0;
        for (Score score : results) {
            System.out.println(++i + ". " + score.getScore() + ", " + score.getName());
        }
    }
}
