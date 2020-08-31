package com.telran.supplier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class FileReadingThread extends Thread {

    BlockingQueue<String> lineQueue;
    BufferedReader br;

    public FileReadingThread(BlockingQueue<String> lineQueue, BufferedReader br) {
        this.lineQueue = lineQueue;
        this.br = br;
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                lineQueue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
