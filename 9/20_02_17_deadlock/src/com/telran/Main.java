package com.telran;

public class Main {

    public static void main(String[] args) {

        Thread th1 = new DeadlockThread();
        Thread th2 = new DeadlockThread();

        th1.start();
        th2.start();


    }
}
