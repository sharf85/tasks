package com.telran;

import com.telran.handler.HandlerPriorityQueue;
import com.telran.handler.HandlerServer;

import java.io.IOException;
import java.net.*;

public class OuterServerSender implements Runnable {
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

            HandlerServer handler = servers.getOptimal();

            if (handler == null)
                return;

            byte[] dataOut = handler.toString().getBytes();
            DatagramPacket packetOut = new DatagramPacket(
                    dataOut,
                    dataOut.length,
                    address,
                    OUTER_SERVER_PORT);
            socket.send(packetOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
