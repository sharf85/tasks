package com.telran;

public class IncrementingThread extends Thread {

    Incrementer incrementer;
    int iterationsNumber;

    public IncrementingThread(Incrementer incrementer, int iterationsNumber) {
        this.incrementer = incrementer;
        this.iterationsNumber = iterationsNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterationsNumber; i++) {
            incrementer.increment();
            incrementer.increment2();
        }
    }
}
