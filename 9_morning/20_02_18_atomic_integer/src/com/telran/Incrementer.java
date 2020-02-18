package com.telran;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementer {

    private AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.getAndIncrement();
    }

    public int getCounter() {
        return counter.get();
    }

}
