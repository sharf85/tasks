package com.telran;

import java.util.Scanner;

public class SenderThread extends Thread {

    Messenger messenger;

    public SenderThread(Messenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()) != null && !line.equals("exit")) {
            messenger.addMessage(line);
        }
    }
}
