package com.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        CharPrinter runnable = new CharPrinter('*', 100);
        Thread th = new Thread(runnable);

        long currentTime = System.currentTimeMillis();
        th.start();

        //this method forces the main thread wait for the end of th execution
        th.join();

        long executionTime = System.currentTimeMillis() - currentTime;
        System.out.println("Time of execution is :" + executionTime);
        System.out.println("End of main");
    }
}
