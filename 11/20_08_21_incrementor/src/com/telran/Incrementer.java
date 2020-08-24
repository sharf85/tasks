package com.telran;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementer {

    final Object mu1 = new Object();

    private int counter;
    private final AtomicInteger counter2 = new AtomicInteger();

    public void increment() {
        synchronized (mu1) {
            counter++;
        }
    }

    public void increment2() {
        counter2.incrementAndGet();
    }

    public int getCounter() {
        return counter;
    }

    public int getCounter2() {
        return counter2.get();
    }
}
