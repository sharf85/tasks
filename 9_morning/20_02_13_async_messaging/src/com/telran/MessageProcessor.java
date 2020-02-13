package com.telran;

public class MessageProcessor implements Runnable {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(message);
            }
        }
    }
}
