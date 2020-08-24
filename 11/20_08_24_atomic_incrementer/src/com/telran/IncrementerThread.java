package com.telran;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementerThread extends Thread {

    private final int times;
    private final AtomicInteger incrementer;

    public IncrementerThread(AtomicInteger atomicNumber, int times) {
        this.incrementer = atomicNumber;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            incrementer.incrementAndGet();
        }
    }
}
