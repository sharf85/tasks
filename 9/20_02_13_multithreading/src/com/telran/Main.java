package com.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        SymbolPrinter printer = new SymbolPrinter(100, '*');
        Thread th = new Thread(printer);

        long currentTime = System.currentTimeMillis();
        th.start();
        th.join();

        long executionTime = System.currentTimeMillis() - currentTime;
        System.out.println("Execution time " + executionTime);

        System.out.println("End of main");
    }
}
