package com.telran;

public class IncrementingThread extends Thread {

    Incrementer incrementer;
    int times;

    public IncrementingThread(Incrementer incrementer, int times) {
        this.incrementer = incrementer;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            incrementer.increment();
            incrementer.atomicIncrement();
        }
    }

}
