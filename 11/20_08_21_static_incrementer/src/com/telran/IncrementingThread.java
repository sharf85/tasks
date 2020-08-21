package com.telran;

public class IncrementingThread extends Thread {

    private final int timesToIncrement;

    public IncrementingThread(int timesToIncrement) {
        this.timesToIncrement = timesToIncrement;
    }

    @Override
    public void run() {
        for (int i = 0; i < timesToIncrement; i++) {
            StaticIncrementer.increment();
        }
    }
}
