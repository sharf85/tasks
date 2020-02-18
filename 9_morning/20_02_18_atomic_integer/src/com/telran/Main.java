package com.telran;

public class Main {

    private static final int THREADS_NUMBER = 1000;
    private static final int ITERATIONS_NUMBER = 100000;

    public static void main(String[] args) throws InterruptedException {
        Incrementer incrementer = new Incrementer();

        Thread[] threads = new IncrementingThread[THREADS_NUMBER];
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Thread th = new IncrementingThread(incrementer, ITERATIONS_NUMBER);
            threads[i] = th;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < THREADS_NUMBER; i++) {
            threads[i].start();
        }

        for (int i = 0; i < THREADS_NUMBER; i++) {
            threads[i].join();
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(incrementer.getCounter());
    }
}