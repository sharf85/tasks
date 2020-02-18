package com.telran;

import java.util.concurrent.locks.ReentrantLock;

public class Incrementer {

    Object mu1 = new Object();
    Object mu2 = new Object();

    ReentrantLock lock = new ReentrantLock();

    int counter;
    int counter2;

//    public synchronized void increment() {
//        counter++;
//    }

    public void increment() {
        synchronized (mu1) {
            counter++;
        }
    }

    public void increment2() {
        lock.lock();
        counter2++;
        lock.unlock();
    }

    public int getCounter() {
        return counter;
    }

    public int getCounter2() {
        return counter2;
    }
}
