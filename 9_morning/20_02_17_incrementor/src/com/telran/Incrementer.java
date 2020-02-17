package com.telran;

import java.util.concurrent.locks.ReentrantLock;

public class Incrementer {

    Object mu1 = new Object();

    ReentrantLock lock2 = new ReentrantLock();
    ReentrantLock lock1 = new ReentrantLock();

    private int counter;
    private int counter2;

    public void increment() {
        synchronized (mu1) {
            counter++;
        }
    }

    public void increment2() {
        lock2.lock();
        counter2++;
        lock2.unlock();
    }

    // the same as
//    public synchronized void increment() {
//        counter++;
//    }


    public int getCounter() {
        return counter;
    }

    public int getCounter2() {
        return counter2;
    }
}
