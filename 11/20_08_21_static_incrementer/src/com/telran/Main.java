package com.telran;

public class Main {

    private static final int TIMES_TO_INCREMENT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new IncrementingThread(TIMES_TO_INCREMENT);
        Thread th2 = new IncrementingThread(TIMES_TO_INCREMENT);
        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(StaticIncrementer.getCounter());
    }
}
