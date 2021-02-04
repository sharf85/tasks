package de.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start main thread");

        CharThread starThread = new CharThread(20, '*');
        CharThread plusThread = new CharThread(20, '+');

        starThread.start();
        plusThread.start();

        starThread.join();
        plusThread.join();

        System.out.println("End of main thread");
    }

}
