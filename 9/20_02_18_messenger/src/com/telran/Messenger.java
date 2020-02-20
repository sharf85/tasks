package com.telran;

public class Messenger {

    private final Object mu1 = new Object();
    private final Object mu2 = new Object();

    private String message;

    public String getMessage() throws InterruptedException {
        synchronized (mu1) {
            while (message == null)
                mu1.wait();
        }

        synchronized (mu2) {
            String res = message;
            message = null;
            mu2.notify();
            return res;
        }
    }

    public void addMessage(String message) throws InterruptedException {
        synchronized (mu2) {
            while (this.message != null)
                mu2.wait();
        }

        synchronized (mu1) {
            this.message = message;
            mu1.notify();
        }
    }
}
