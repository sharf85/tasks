package com.telran.handler;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlersListener extends Thread {
    private static final int DATAGRAM_SIZE = 1024;
    private static final int BALANCER_UDP_PORT = 2345;
    private static final int THREADS_NUM = 10;

    private HandlerPriorityQueue servers;

    public HandlersListener(HandlerPriorityQueue servers) {
        this.servers = servers;
    }

    @Override
    public void run() {
        try {
            DatagramSocket serverSocket = new DatagramSocket(BALANCER_UDP_PORT);
            ExecutorService executor = Executors.newFixedThreadPool(THREADS_NUM);
            while (true) {
                byte[] dataFromHandler = new byte[DATAGRAM_SIZE];
                DatagramPacket packetFromHandler = new DatagramPacket(dataFromHandler, DATAGRAM_SIZE);
                serverSocket.receive(packetFromHandler);

                executor.execute(new HandlerDataReceiver(
                        packetFromHandler,
                        servers
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
