package com.telran;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    // the port which listens to Backends
    static final int UDP_BALANCER_PORT = 5001;
    static final String BALANCER_HOST = "localhost";
    private static final int DEFAULT_BACKEND_PORT = 3000;

    public static void main(String[] args) throws IOException {

        int serverPort = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_BACKEND_PORT;
        ExecutorService pool = Executors.newFixedThreadPool(10);


        BalancerUpdater udpThread = new BalancerUpdater(BALANCER_HOST, UDP_BALANCER_PORT, serverPort);
        pool.execute(udpThread);

        // the server object which reserves a certain port and then listens for new connections (sockets)
        ServerSocket serverSocket = new ServerSocket(serverPort);

        while (true) {
            // the server accepts a connection
            Socket socket = serverSocket.accept();

            Runnable serverTaskThread = new BackendTask(socket);
            pool.execute(serverTaskThread);
        }
    }
}
