package com.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class BalancerListener extends Thread {

    private static final int DATA_SIZE = 1024;
    private static final String DELIMITER = ":";
    private int outerServerUdpPort;
    private HandlerInfo handler;

    public BalancerListener(int outerServerUdpPort, HandlerInfo lastHandler) {
        this.outerServerUdpPort = outerServerUdpPort;
        this.handler = lastHandler;
    }

    @Override
    public void run() {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(outerServerUdpPort);
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }

        byte[] dataIn = new byte[DATA_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, DATA_SIZE);

        while (true) {
            try {
                serverSocket.receive(packetIn);
                String handlerData = new String(dataIn, 0, packetIn.getLength());
                updateHandler(handlerData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void updateHandler(String handlerData) {
        String[] parts = handlerData.split(DELIMITER);
        String host = parts[0];
        int port = Integer.parseInt(parts[1]);
        handler.setHost(host);
        handler.setPort(port);
    }
}
