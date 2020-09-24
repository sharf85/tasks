package com.telran;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpProxy implements Runnable {

    int outerTcpPort;
    final BackendServerDataStorage serverData;

    public TcpProxy(BackendServerDataStorage serverData, int outerTcpPort) {
        this.serverData = serverData;
        this.outerTcpPort = outerTcpPort;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(outerTcpPort);

            while (true) {
                // the server accepts a connection
                Socket clientSocket = serverSocket.accept();

                TcpProxyTask task = new TcpProxyTask(serverData, clientSocket);
                Thread tcpProxyThread = new Thread(task);
                tcpProxyThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
