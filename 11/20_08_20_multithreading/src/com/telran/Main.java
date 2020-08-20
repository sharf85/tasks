package com.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long startTimestamp = System.currentTimeMillis();

        Thread th = new CharPrinter('*', 100);
        th.start();
        th.join();

        long endTimestamp = System.currentTimeMillis();
        System.out.println(endTimestamp - startTimestamp);
    }
}
