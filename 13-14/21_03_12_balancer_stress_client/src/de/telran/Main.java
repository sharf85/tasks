package de.telran;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static final int SIMULTANEOUS_CONNECTION_NUMBER = 20;
    static final int CONNECTION_NUMBER = 1000;
    static final int MESSAGES_PER_CONNECTION = 1000;
    static final String MESSAGE = "I love you";

    static final String GATEWAY_HOST = "localhost";
    static final int GATEWAY_TCP_PORT = 3000;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(SIMULTANEOUS_CONNECTION_NUMBER);

        for (int i = 0; i < CONNECTION_NUMBER; i++) {
            executorService.execute(new ConnectionTask(GATEWAY_HOST, GATEWAY_TCP_PORT, MESSAGE, MESSAGES_PER_CONNECTION));
        }
    }
}


