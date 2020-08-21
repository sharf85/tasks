package com.telran;

public class StaticIncrementer {
    private final static Object mu1 = new Object();

    private static int counter;

    public static void increment() {
        synchronized (mu1) {
            counter++;
        }
    }

    public static int getCounter() {
        return counter;
    }
}
