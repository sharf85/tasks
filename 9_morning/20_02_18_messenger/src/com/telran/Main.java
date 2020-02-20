package com.telran;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Messenger messenger = new Messenger();
        PrintWriter pw = new PrintWriter("output.txt");

        Thread sender = new Sender(messenger);
        sender.start();

        Thread[] receivers = new Thread[5];
        for (int i = 0; i < receivers.length; i++) {
            receivers[i] = new Receiver(messenger, pw);
            receivers[i].setDaemon(true);
        }

        for (int i = 0; i < receivers.length; i++) {
            receivers[i].start();
        }

        sender.join();
        pw.close();
    }
}
