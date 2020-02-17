package com.telran;

public class Main {

    public static void main(String[] args) {
        Thread th1 = new DeadLockThread();
        Thread th2 = new DeadLockThread();

        th1.start();
        th2.start();


    }
}
