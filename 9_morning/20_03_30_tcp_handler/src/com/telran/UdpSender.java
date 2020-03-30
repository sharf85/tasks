package com.telran;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UdpSender implements Runnable {

    private static final String DELIMITER = ":";
    private AtomicInteger tasksNum;
    private String balancerHost;
    private int balancerUdpPort;
    private int handlerTcpPort;

    public UdpSender(AtomicInteger tasksNum,
                     String balancerHost,
                     int balancerUdpPort,
                     int handlerTcpPort
    ) {
        this.tasksNum = tasksNum;
        this.balancerUdpPort = balancerUdpPort;
        this.balancerHost = balancerHost;
        this.handlerTcpPort = handlerTcpPort;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();

            String lineToSend = handlerTcpPort + DELIMITER + tasksNum.toString();
            byte[] dataOut = lineToSend.getBytes();

            DatagramPacket packetOut = new DatagramPacket(
                    dataOut,
                    dataOut.length,
                    InetAddress.getByName(balancerHost),
                    balancerUdpPort
            );
            socket.send(packetOut);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
