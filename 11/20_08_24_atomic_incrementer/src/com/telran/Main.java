package com.telran;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicNumber = new AtomicInteger();
        Thread th1 = new IncrementerThread(atomicNumber, 100_000);
        Thread th2 = new IncrementerThread(atomicNumber, 100_000);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(atomicNumber.get());
    }
}
