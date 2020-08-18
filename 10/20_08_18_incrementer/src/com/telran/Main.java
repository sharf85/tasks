package com.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Incrementer incrementer = new Incrementer();

        Thread th1 = new IncrementingThread(incrementer, 100000);
        Thread th2 = new IncrementingThread(incrementer, 100000);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(incrementer.getValue());
        System.out.println(incrementer.getAtomicValue());
    }
}
