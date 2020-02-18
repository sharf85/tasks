package com.telran;

public class CounterThread extends Thread {

    int iterNum;
    static int counter;

    public CounterThread(int iterNum) {
        this.iterNum = iterNum;
    }

    public void incrementStatic() {
        counter++;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterNum; i++) {
            incrementStatic();
        }
    }
}
