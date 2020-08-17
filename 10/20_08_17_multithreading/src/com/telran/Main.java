package com.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CharPrinter printer1 = new CharPrinter('*', 100);
        CharPrinter printer2 = new CharPrinter('#', 100);
        Thread th1 = new Thread(printer1);
        Thread th2 = new Thread(printer2);

        long beforeStart = System.currentTimeMillis();
        th1.start();
        th2.start();

        th1.join();
        th2.join();
        long afterStart = System.currentTimeMillis();
        System.out.println(afterStart - beforeStart);
    }
}
