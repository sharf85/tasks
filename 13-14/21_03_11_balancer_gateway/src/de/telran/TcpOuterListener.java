package de.telran;

import de.telran.server.ServerSource;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpOuterListener implements Runnable {
    ServerSource serverSource;
    int tcpOuterPort;

    public TcpOuterListener(ServerSource serverSource, int tcpOuterPort) {
        this.serverSource = serverSource;
        this.tcpOuterPort = tcpOuterPort;
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(tcpOuterPort);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        ExecutorService executor = Executors.newFixedThreadPool(20);

        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Connected");

            Runnable serverTask = new ServerProxiTask(socket, serverSource);
            executor.execute(serverTask);
        }
    }
}
