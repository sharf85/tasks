package com.telran;

public class IncrementingThread extends Thread {

    private Incrementer incrementer;
    private int incrementsNumber;

    public IncrementingThread(Incrementer incrementer, int incrementsNumber) {
        this.incrementer = incrementer;
        this.incrementsNumber = incrementsNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementsNumber; i++) {
            incrementer.increment();
            incrementer.increment2();
        }
    }
}
