package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        MessageHandler handler = new MessageHandler();
        Thread th = new Thread(handler);
        th.setDaemon(true);
        th.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.equals("exit")) {
            handler.setMessage(line);
            th.interrupt();
        }

    }
}
