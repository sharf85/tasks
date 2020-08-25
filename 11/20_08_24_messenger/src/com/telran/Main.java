package com.telran;

public class Main {

    public static void main(String[] args) {
        //Create 3 same consumers and one supplier, make consumers daemon.
        OneElementBlockingQueue queue = new OneElementBlockingQueue();
        Thread supplier = new StringSupplier(queue);

        Thread[] consumers = new StringConsumer[5];

        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new StringConsumer(queue);
            consumers[i].setDaemon(true);
            consumers[i].start();
        }
        supplier.start();
    }
}
