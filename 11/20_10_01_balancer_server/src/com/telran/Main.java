package com.telran;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final int LOAD_BALANCER_UDP_PORT = 5001;
    private static final int REPORTING_PERIOD = 100;
    private static final String BALANCER_HOST = "localhost";
    private static final String BACKEND_HOST = "localhost";

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);

        AtomicInteger socketCounter = new AtomicInteger();

        // start Load Reporter
        Thread reporterThread = new Thread(
                new LoadReporter(LOAD_BALANCER_UDP_PORT,
                        socketCounter,
                        REPORTING_PERIOD,
                        BALANCER_HOST,
                        BACKEND_HOST,
                        port
                ));
        reporterThread.start();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        // the server object which reserves a certain port and then listens for new connections (sockets)
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            // the server accepts a connection
            Socket socket = serverSocket.accept();
            socketCounter.incrementAndGet();

            pool.execute(new ServerTask(socket, socketCounter));
        }
    }
}
