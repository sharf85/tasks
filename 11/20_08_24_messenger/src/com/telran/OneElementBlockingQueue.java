package com.telran;

public class OneElementBlockingQueue {

    final Object readerMutex = new Object();

    volatile String element;

    public String removeLast() throws InterruptedException {
        synchronized (readerMutex) {
            while (element == null)
                readerMutex.wait();

            String res = element;
            element = null;
            return res;
        }
    }

    public void addFirst(String line) {
        synchronized (readerMutex) {
            element = line;
            readerMutex.notify();
        }
    }
}
