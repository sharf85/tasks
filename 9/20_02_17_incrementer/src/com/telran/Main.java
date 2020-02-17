package com.telran;

public class Main {

    private static final int ITER_NUM = 100000;
    private static final int THREADS_NUM = 1000;

    public static void main(String[] args) throws InterruptedException {
        Incrementer incrementer = new Incrementer();

        Thread[] threads = new Thread[THREADS_NUM];
        for (int i = 0; i < THREADS_NUM; i++) {
            threads[i] = new IncrementingThread(incrementer, ITER_NUM);
        }

        for (int i = 0; i < THREADS_NUM; i++) {
            threads[i].start();
        }

        for (int i = 0; i < THREADS_NUM; i++) {
            threads[i].join();
        }
        System.out.println(incrementer.getCounter());
        System.out.println(incrementer.getCounter2());
    }
}
