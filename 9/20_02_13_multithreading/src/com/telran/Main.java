package com.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        SymbolPrinter printer1 = new SymbolPrinter(100, '*');
        Thread th1 = new Thread(printer1);
        SymbolPrinter printer2 = new SymbolPrinter(100, '=');
        Thread th2 = new Thread(printer2);
        SymbolPrinter printer3 = new SymbolPrinter(100, '+');
        Thread th3 = new Thread(printer3);

        th1.setDaemon(true);
        th2.setDaemon(true);
        th3.setDaemon(true);

        long currentTime = System.currentTimeMillis();
        th1.start();
        th2.start();
        th3.start();
//        th1.join();
//        th2.join();
//        th3.join();

        long executionTime = System.currentTimeMillis() - currentTime;
        System.out.println("Execution time " + executionTime);

        System.out.println("End of main");
    }
}
