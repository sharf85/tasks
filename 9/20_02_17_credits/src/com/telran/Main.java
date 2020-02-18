package com.telran;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final int MAX_TIME = 150;
    private static final int MIN_TIME = 100;
    private static final int CREDITS_NUMBER = 20;

    public static void main(String[] args) throws InterruptedException {
        AbstractClerk masha = new UsualClerk(
                (int) (MIN_TIME / 1.2),
                (int) (MAX_TIME / 1.2),
                CREDITS_NUMBER,
                "Masha");

        AbstractClerk petya = new UsualClerk(
                MIN_TIME,
                MAX_TIME,
                CREDITS_NUMBER,
                "Petya"
        );

        AbstractClerk vasya = new LazyInspiredClerk(
                MIN_TIME,
                MAX_TIME,
                CREDITS_NUMBER,
                "Vasya",
                1.5,
                25
        );

        List<AbstractClerk> clerks = Arrays.asList(vasya, masha, petya);
        List<Thread> threads = Arrays.asList(
                new Thread(vasya),
                new Thread(masha),
                new Thread(petya));

        long startTime = System.currentTimeMillis();
        for (Thread th : threads) {
            th.start();
        }

        for (Thread th : threads) {
            th.join();
        }

        for (AbstractClerk clerk : clerks) {
            System.out.println("The clerk called " + clerk.getName() + " completed for "
                    + (clerk.finishTime - startTime));
        }
    }
}
