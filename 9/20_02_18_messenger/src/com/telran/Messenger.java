package com.telran;

public class Messenger {

    private final Object mu = new Object();

    private String message;

    public String getMessage() throws InterruptedException {
        synchronized (mu) {
            while (message == null)
                mu.wait();

            String res = message;
            message = null;
            return res;
        }
    }

    public void addMessage(String message) {
        synchronized (mu) {
            this.message = message;
            mu.notify();
        }
    }
}
