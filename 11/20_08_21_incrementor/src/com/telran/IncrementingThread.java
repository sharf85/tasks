package com.telran;

public class IncrementingThread extends Thread {

    private final Incrementer incrementer;
    private final int timesToIncrement;

    public IncrementingThread(Incrementer incrementer, int timesToIncrement) {
        this.incrementer = incrementer;
        this.timesToIncrement = timesToIncrement;
    }

    @Override
    public void run() {
        for (int i = 0; i < timesToIncrement; i++) {
            incrementer.increment();
            incrementer.increment2();
        }
    }
}
