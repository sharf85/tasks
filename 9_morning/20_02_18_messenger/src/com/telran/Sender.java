package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sender extends Thread {

    private Messenger messenger;

    public Sender(Messenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public void run() {
        try (BufferedReader isr = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = isr.readLine()) != null && !line.equals("exit")) {
                messenger.addMessage(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
