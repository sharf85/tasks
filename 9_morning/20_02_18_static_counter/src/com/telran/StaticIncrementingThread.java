package com.telran;

import java.util.concurrent.locks.ReentrantLock;

public class StaticIncrementingThread extends Thread {

    private static final Object mu = new Object();
    private static final ReentrantLock lock = new ReentrantLock();

    private static int counter;
    private int iterNum;

    public StaticIncrementingThread(int iterNum) {
        this.iterNum = iterNum;
    }

    public static int getCounter() {
        return counter;
    }

    private void increment() {
        lock.lock();
        counter++;
        lock.unlock();
//        synchronized (mu) {
//            counter++;
//        }
    }

    @Override
    public void run() {
        for (int i = 0; i < iterNum; i++) {
            increment();
        }
    }
}
