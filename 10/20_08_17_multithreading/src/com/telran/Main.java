package com.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CharPrinter printer1 = new CharPrinter('*', 100);
        Thread th = new Thread(printer1);

        long beforeStart = System.currentTimeMillis();
        th.start();
        th.join();
        long afterStart = System.currentTimeMillis();
        System.out.println(afterStart - beforeStart);
    }
}
