package com.telran;

import java.io.PrintWriter;

public class ReceiverThread extends Thread {

    Messenger messenger;
    PrintWriter pw;

    public ReceiverThread(Messenger messenger, PrintWriter pw) {
        this.messenger = messenger;
        this.pw = pw;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String line = messenger.getMessage();
                synchronized (ReceiverThread.class) {
                    pw.println(line + " " + getName());
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
