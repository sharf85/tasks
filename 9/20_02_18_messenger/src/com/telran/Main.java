package com.telran;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        PrintWriter pw = new PrintWriter("output.txt");
        Messenger messenger = new Messenger();
        Thread senderThread = new SenderThread(messenger);

        Thread[] receivers = new Thread[5];
        for (int i = 0; i < receivers.length; i++) {
            receivers[i] = new ReceiverThread(messenger, pw);
            receivers[i].setDaemon(true);
        }

        for (int i = 0; i < receivers.length; i++) {
            receivers[i].start();
        }

        senderThread.start();
        senderThread.join();
        pw.close();
    }
}
