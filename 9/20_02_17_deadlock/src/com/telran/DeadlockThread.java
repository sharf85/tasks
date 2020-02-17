package com.telran;

public class DeadlockThread extends Thread {

    private static final Object mu1 = new Object();
    private static final Object mu2 = new Object();

    public void func1() throws InterruptedException {
        synchronized (mu1) {
            sleep(100);
            synchronized (mu2) {
                sleep(100);
                System.out.println("inside func1");
            }
        }
    }

    public void func2() throws InterruptedException {
        synchronized (mu2) {
            sleep(100);
            synchronized (mu1) {
                sleep(100);
                System.out.println("inside func2");
            }
        }
    }

    @Override
    public void run() {
        try {
            func1();
            func2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
