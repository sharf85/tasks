package de.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        IncrementingInteger incInteger = new IncrementingInteger();

        Thread th1 = new IncrementingThread(incInteger, 100000);
        Thread th2 = new IncrementingThread(incInteger, 100000);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("Incremented times: " + incInteger.get());
    }
}
