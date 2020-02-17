package com.telran;

public class Main {

    private static final int MIN_TIME = 100;
    private static final int MAX_TIME = 150;
    private static final int CREDITS_NUM = 20;

    public static void main(String[] args) throws InterruptedException {
        AbstractClerk masha = new RegularClerk("Masha", (int) (MIN_TIME / 1.2), (int) (MAX_TIME / 1.2), CREDITS_NUM);
        AbstractClerk petya = new RegularClerk("Petya", MIN_TIME, MAX_TIME, CREDITS_NUM);
        AbstractClerk vasya = new LazyInspiredClerk("Vasya", MIN_TIME, MAX_TIME, CREDITS_NUM, 1.5);

        AbstractClerk[] clerks = {masha, petya, vasya};

        Thread th1 = new Thread(masha);
        Thread th2 = new Thread(petya);
        Thread th3 = new Thread(vasya);

        long startTime = System.currentTimeMillis();
        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        for (int i = 0; i < clerks.length; i++) {
            System.out.println("The clerk called " + clerks[i].getName() + " issued " +
                    "all credits for " + (clerks[i].getFinishTime() - startTime));
        }
    }
}
