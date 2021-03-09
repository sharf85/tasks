package de.telran;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static int TCP_PORT = 3000;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(TCP_PORT);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Connected");

            Runnable serverTask = new ServerTask(socket);
            executor.execute(serverTask);
        }
    }
}

