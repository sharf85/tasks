package com.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int TARAKAN_NUM = 10;
    private static final int MIN_TIME = 100;
    private static final int MAX_TIME = 150;
    private static final int STEPS_NUM = 10;

    public static void main(String[] args) throws InterruptedException {

        List<FinishInfo> winRate = new ArrayList<>();
        List<Thread> threads = makeTarakanThreads(winRate);
        long startTime = System.currentTimeMillis();
        start(threads);
        join(threads);

        printWiners(winRate, startTime);

    }

    private static void printWiners(List<FinishInfo> winRate, long startTime) {
        for (int i = 0; i < winRate.size(); i++) {
            System.out.println("Tarakan number " + winRate.get(i).getTarakanId() +
                    " finished on the " + i + " place and came to the finish for " +
                    (winRate.get(i).getFinishTime() - startTime)
            );
        }
    }

    private static void join(List<Thread> threads) throws InterruptedException {
        for (Thread th : threads) {
            th.join();
        }
    }

    private static void start(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static List<Thread> makeTarakanThreads(List<FinishInfo> winRate) {
        List<Thread> res = new ArrayList<>();
        for (int i = 0; i < TARAKAN_NUM; i++) {
            Tarakan tarakan = new Tarakan(i, STEPS_NUM, MIN_TIME, MAX_TIME, winRate);
            Thread th = new Thread(tarakan);
            res.add(th);
        }
        return res;
    }
}
