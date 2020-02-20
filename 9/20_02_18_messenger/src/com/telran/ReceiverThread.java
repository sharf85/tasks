package com.telran;

public class ReceiverThread extends Thread {

    Messenger messenger;

    public ReceiverThread(Messenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String line = messenger.getMessage();
                System.out.println(line + " " + getName());
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
