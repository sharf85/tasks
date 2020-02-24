package com.telran.producer;

import com.telran.service.FileService;

import java.io.IOException;
import java.util.concurrent.BlockingDeque;

public class TextProducer implements Runnable {

    private FileService fs;
    private BlockingDeque<String> deque;

    public TextProducer(FileService fs, BlockingDeque<String> deque) {
        this.fs = fs;
        this.deque = deque;
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = fs.readLine()) != null) {
                deque.addLast(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
