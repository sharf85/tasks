package de.telran;

public class IntegerWrapper {
    private int number;

    public void increment() {
        synchronized (this) {
            number++;
        }
    }

    public int getNumber() {
        return number;
    }
}
