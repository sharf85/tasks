package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Score> scores = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        Worker masha = new Worker(
                150,
                100,
                scores,
                20,
                "Masha",
                startTime);
        Worker petya = new Worker(
                200,
                150,
                scores,
                20,
                "Petya",
                startTime);
        Worker vasya = new CreativeWorker(
                200,
                150,
                scores,
                20,
                "Vasya",
                startTime,
                100,
                50,
                20,
                3);

        Thread[] workers = new Thread[]{new Thread(masha), new Thread(petya), new Thread(vasya)};

        for (Thread workerThread : workers) {
            workerThread.start();
        }

        for (Thread workerThread : workers) {
            workerThread.join();
        }

        System.out.println(scores);
    }
}
