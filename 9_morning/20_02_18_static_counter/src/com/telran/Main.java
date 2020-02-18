package com.telran;

public class Main {

    private static final int ITER_NUM = 100000;
    private static final int THREAD_NUM = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new StaticIncrementingThread(ITER_NUM);
        }

        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i].start();
        }

        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i].join();
        }

        System.out.println(StaticIncrementingThread.getCounter());

    }
}
