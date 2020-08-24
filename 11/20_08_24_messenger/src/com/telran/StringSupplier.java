package com.telran;

public class StringSupplier extends Thread {
    private final OneElementBlockingQueue queue;

    public StringSupplier(OneElementBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //Must accept lines from System.in and put them into the queue. See Echo Messenger project
    }
}
