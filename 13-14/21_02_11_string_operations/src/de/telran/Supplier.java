package de.telran;

import java.io.BufferedReader;
import java.util.concurrent.BlockingQueue;

/**
 *
 */
public class Supplier implements Runnable {

    private final BufferedReader br;
    private final BlockingQueue<String> queue;

    public Supplier(BufferedReader br, BlockingQueue<String> queue) {
        this.br = br;
        this.queue = queue;
    }

    @Override
    public void run() {
        //TODO read lines and pass every line to the queue via method put
    }
}
