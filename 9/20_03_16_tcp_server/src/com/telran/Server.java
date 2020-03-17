package com.telran;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    final static int PORT = 3000;
    final static int N_THREADS = 5;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

        while (true) {
            Socket socket = server.accept();
            Runnable serverTask = new ServerTask(socket);
            executor.execute(serverTask);
//            new Thread(serverTask).start();
        }
    }
}
