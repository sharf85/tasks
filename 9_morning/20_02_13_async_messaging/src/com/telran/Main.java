package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        MessageProcessor mp = new MessageProcessor();
        Thread processorThread = new Thread(mp);
        processorThread.setDaemon(true);
        processorThread.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.equals("exit")) {
            mp.setMessage(line);
            processorThread.interrupt();
        }

    }
}
