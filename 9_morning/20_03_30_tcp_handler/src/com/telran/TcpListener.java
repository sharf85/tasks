package com.telran;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TcpListener extends Thread {

    int handlerTcpPort;
    AtomicInteger tasksNum;

    public TcpListener(int handlerTcpPort, AtomicInteger tasksNum) {
        this.handlerTcpPort = handlerTcpPort;
        this.tasksNum = tasksNum;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(handlerTcpPort);
            ExecutorService executor = Executors.newCachedThreadPool();

            while (true) {
                Socket socketIn = server.accept();
                Runnable taskHandler = new TaskHandler(socketIn, tasksNum);
                tasksNum.incrementAndGet();
                executor.execute(taskHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
