package com.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
// Initialize scores list. Then initialize and start all tarakans.
// Then join all the tarakans. Then print the scores out.
        List<Score> scores = new ArrayList<>();

        Thread[] tarakanThreads = new Thread[10];
        for (int i = 1; i <= tarakanThreads.length; i++) {
            tarakanThreads[i - 1] = new Thread(new Tarakan(10, "Tarakan " + i, scores));
        }

        for (int i = 0; i < tarakanThreads.length; i++) {
            tarakanThreads[i].start();
        }

        for (int i = 0; i < tarakanThreads.length; i++) {
            tarakanThreads[i].join();
        }

        int i = 1;
        for (Score score : scores) {
            System.out.println(String.format("%d, %s finished for %d", (i++), score.getName(), score.getResult()));
        }
    }
}
