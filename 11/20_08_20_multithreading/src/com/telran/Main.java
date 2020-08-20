package com.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long startTimestamp = System.currentTimeMillis();

        Thread th1 = new CharPrinter('*', 100);
        Thread th2 = new CharPrinter('+', 100);
        th1.start();
        th2.start();

        th1.join();
        th2.join();

        long endTimestamp = System.currentTimeMillis();
        System.out.println(endTimestamp - startTimestamp);
    }
}
