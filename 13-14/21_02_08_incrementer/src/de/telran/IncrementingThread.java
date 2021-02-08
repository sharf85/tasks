package de.telran;

public class IncrementingThread extends Thread {

    private final IncrementingInteger incInteger;
    private final int times;

    public IncrementingThread(IncrementingInteger incInteger, int times) {
        this.incInteger = incInteger;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            incInteger.increment();
        }
    }
}
