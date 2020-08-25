package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSupplier extends Thread {
    private final OneElementBlockingQueue queue;

    public StringSupplier(OneElementBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                queue.addFirst(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
