package com.telran;

public class Messenger {

    private final Object mu = new Object();

    private volatile String message;

    public void addMessage(String message) {
        synchronized (mu) {
            this.message = message;
            mu.notify();
        }
    }

    public String removeMessage() throws InterruptedException {
        synchronized (mu) {
            while (message == null)
                mu.wait();

            String res = message;
            message = null;
            return res;
        }
    }
}
