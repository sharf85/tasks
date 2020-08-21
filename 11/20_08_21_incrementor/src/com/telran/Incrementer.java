package com.telran;

public class Incrementer {

    final Object mu1 = new Object();
    final Object mu2 = new Object();

    private int counter;
    private int counter2;

    public void increment() {
        synchronized (mu1) {
            counter++;
        }
    }

    public void increment2() {
        synchronized (mu2) {
            counter2++;
        }
    }

    public int getCounter() {
        return counter;
    }

    public int getCounter2() {
        return counter2;
    }
}
