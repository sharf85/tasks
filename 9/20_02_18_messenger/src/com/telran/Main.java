package com.telran;

public class Main {

    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        Thread senderThread = new SenderThread(messenger);

        Thread[] receivers = new Thread[5];
        for (int i = 0; i < receivers.length; i++) {
            receivers[i] = new ReceiverThread(messenger);
            receivers[i].setDaemon(true);
        }

        for (int i = 0; i < receivers.length; i++) {
            receivers[i].start();
        }

        senderThread.start();
    }
}
