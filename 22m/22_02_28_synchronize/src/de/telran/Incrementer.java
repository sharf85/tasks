package de.telran;

public class Incrementer implements Runnable {

    private final IntegerWrapper wrapper;
    private final int numberToIncrement;

    public Incrementer(IntegerWrapper wrapper, int numberToIncrement) {
        this.wrapper = wrapper;
        this.numberToIncrement = numberToIncrement;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberToIncrement; i++) {
            wrapper.increment();
        }
    }
}
