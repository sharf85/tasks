package de.telran;

public class Main {

    // Многопоточность (multithreading) - это возможность составить программу таким образом, что
    // операции в ней обрабатываются параллельно
    // В Java поток можно начать 2мя способами (основными)
    // 1. используя класс Thread
    // 2. используя класс Runnable
    public static void main(String[] args) throws InterruptedException {
        Thread hashThread = new CharThread('#');
        Thread starThread = new CharThread('*');

        hashThread.start();// here we open a new thread
        starThread.start();// here we open a new thread

        hashThread.join();// заставляет поток, из которого вызван join (main thread), ждать на этом месте, пока не закончится поток
        // , от которого вызван join (hashThread)
        starThread.join();

        System.out.println("end of main");
    }
}
