package de.telran;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TcpGatewayListener implements Runnable {
    int selfTcpPort;
    AtomicInteger connectionCounter;

    public TcpGatewayListener(int selfTcpPort, AtomicInteger connectionCounter) {
        this.selfTcpPort = selfTcpPort;
        this.connectionCounter = connectionCounter;
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(selfTcpPort);
            ExecutorService executor = Executors.newFixedThreadPool(10);

            while (true) {
                Socket socket = serverSocket.accept();

                connectionCounter.incrementAndGet();
                Runnable serverTask = new ServerTask(socket, connectionCounter);
                executor.execute(serverTask);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
