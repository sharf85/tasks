package com.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int STEPS = 20;
    private static final int MIN_TIME = 100;
    private static final int MAX_TIME = 150;
    private static final int TARAKANS_NUM = 10;

    public static void main(String[] args) throws InterruptedException {
        List<FinishInfo> winRate = new ArrayList<>();

        List<Thread> threads = createThreads(winRate);
        long startTime = System.currentTimeMillis();
        startThreads(threads);
        joinThreads(threads);

        int i = 0;
        for (FinishInfo info : winRate) {
            System.out.println("Tarakan number " + info.id + " came at " + ++i + " place" +
                    " and it took " + (info.finishTime - startTime) + " time");
        }
    }

    private static void joinThreads(List<Thread> threads) throws InterruptedException {
        for (Thread th : threads) {
            th.join();
        }
    }

    private static void startThreads(List<Thread> threads) {
        for (Thread th : threads) {
            th.start();
        }
    }

    private static List<Thread> createThreads(List<FinishInfo> winRate) {
        List<Thread> res = new ArrayList<>();
        for (int i = 1; i <= TARAKANS_NUM; i++) {
            Tarakan tarakan = new Tarakan(i, MIN_TIME, MAX_TIME, STEPS, winRate);
            res.add(new Thread(tarakan));
        }
        return res;
    }
}
