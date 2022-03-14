package de.telran;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Task());
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
