package de.telran;

public class IncrementingInteger {

//    private final Object mu = new Object();

    private int source;

    public IncrementingInteger(int source) {
        this.source = source;
    }

    public IncrementingInteger() {
    }

    public void increment() {
        // the same
//        int temp = source + 1;
//        source = temp;
        synchronized (this) {
            source++;
        }
    }

//    public synchronized void increment() {
//        source++;
//    }

    public int get() {
        return source;
    }
}
