package de.telran;

public class IncrementerRunnable implements Runnable {

    private final IntegerWrapper wrapper;
    private final int numberToIncrement;

    public IncrementerRunnable(IntegerWrapper wrapper, int numberToIncrement) {
        this.wrapper = wrapper;
        this.numberToIncrement = numberToIncrement;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberToIncrement; i++) {
            wrapper.increment();
            wrapper.decrement();
        }
    }
}
