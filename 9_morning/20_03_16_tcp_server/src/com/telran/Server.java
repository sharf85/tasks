package com.telran;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    // till 2^16
    static final int PORT = 2000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        while (true) {

            Socket socket = server.accept();
            ServerTask task = new ServerTask(socket);

            executor.execute(task);
            //can execute >= 1 second
//            new Thread(task).start();

        }
        //connection established
    }
}
