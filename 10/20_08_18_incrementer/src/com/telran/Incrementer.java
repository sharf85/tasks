package com.telran;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementer {

    int value;
    AtomicInteger atomicValue = new AtomicInteger();

    public synchronized void increment() {
//        synchronized (this) {
        value++;
//        }
    }

    public void atomicIncrement() {
        atomicValue.incrementAndGet();
    }

    public int getValue() {
        return value;
    }

    public int getAtomicValue() {
        return atomicValue.get();
    }
}
