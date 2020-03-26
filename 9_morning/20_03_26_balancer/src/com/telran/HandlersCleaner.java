package com.telran;

import com.telran.handler.HandlerPriorityQueue;

import java.time.Duration;

public class HandlersCleaner extends Thread {

    private static final long CLEAR_TIME = 5000;
    private HandlerPriorityQueue servers;

    public HandlersCleaner(HandlerPriorityQueue servers) {
        this.servers = servers;
    }

    @Override
    public void run() {
        try {
            while (true) {
                servers.removeUnused(Duration.ofMillis(CLEAR_TIME));
                Thread.sleep(CLEAR_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
