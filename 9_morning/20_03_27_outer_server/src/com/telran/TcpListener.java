package com.telran;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpListener extends Thread {

    private HandlerInfo handler;
    private int outerServerTcpPort;

    public TcpListener(int outerServerTcpPort, HandlerInfo lastHandler) {
        handler = lastHandler;
        this.outerServerTcpPort = outerServerTcpPort;
    }

    @Override
    public void run() {
        ServerSocket server;
        try {
            server = new ServerSocket(outerServerTcpPort);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        while (true) {
            try {
                Socket socket = server.accept();
                TcpTask task = new TcpTask(socket, handler);
                executor.execute(task);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
