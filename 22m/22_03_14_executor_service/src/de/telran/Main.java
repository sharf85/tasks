package de.telran;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final String KUKU = "KUKU";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        final String kuku = "kuku";
        for (int i = 0; i < 10; i++) {

            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getId() + " " + KUKU);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
