package com.telran;

public class StringConsumer extends Thread {

    private final OneElementBlockingQueue queue;

    public StringConsumer(OneElementBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String line = queue.removeLast();
                System.out.println(line + " " + this.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
