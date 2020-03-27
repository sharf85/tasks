package com.telran;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpClient {

    private static final int MESSAGES_NUM = 10000;
    private static final String OUTER_SERVER_HOST = "localhost";
    private static final int OUTER_SEVER_TCP_PORT = 3455;
    private static final int THREADS_NUM = 20;
    private static final String MESSAGE = "Hello";

    public static void main(String[] args) throws IOException {

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_NUM);
        for (int i = 0; i < MESSAGES_NUM; i++) {
            Runnable task = new TcpRequest(OUTER_SERVER_HOST, OUTER_SEVER_TCP_PORT, MESSAGE);
            executor.execute(task);
        }

        executor.shutdown();
    }
}
