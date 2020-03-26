package com.telran;

import com.telran.handler.HandlerPriorityQueue;

import java.io.IOException;
import java.net.*;

public class OuterServerSender extends Thread {
    private static final int OUTER_SERVER_PORT = 3456;
    private static final String OUTER_HOST = "localhost";
    private HandlerPriorityQueue servers;


    public OuterServerSender(HandlerPriorityQueue servers) {
        this.servers = servers;
    }

    @Override
    public void run() {
        try {
            InetAddress address = InetAddress.getByName(OUTER_HOST);
            DatagramSocket socket = new DatagramSocket();


            while (true) {
                byte[] dataOut = servers.getOptimal().toString().getBytes();
                DatagramPacket packetOut = new DatagramPacket(
                        dataOut,
                        dataOut.length,
                        address,
                        OUTER_SERVER_PORT);
                socket.send(packetOut);
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
