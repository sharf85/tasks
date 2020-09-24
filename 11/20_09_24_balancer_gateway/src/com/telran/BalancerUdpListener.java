package com.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class BalancerUdpListener implements Runnable {
    final BackendServerDataStorage serverData;
    int fromBalancerUdpPort;

    public BalancerUdpListener(BackendServerDataStorage serverData, int fromBalancerUdpPort) {
        this.serverData = serverData;
        this.fromBalancerUdpPort = fromBalancerUdpPort;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(fromBalancerUdpPort);

            byte[] dataIn = new byte[1024];
            DatagramPacket packetIn = new DatagramPacket(dataIn, dataIn.length);

            while (true) {
                socket.receive(packetIn);

                String body = new String(dataIn, 0, packetIn.getLength());
                String[] hostAndPort = body.split(":");

                synchronized (serverData) {
                    serverData.setHost(hostAndPort[0]);
                    serverData.setPort(Integer.parseInt(hostAndPort[1]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
