package de.telran;

import de.telran.server.ServerData;
import de.telran.server.ServerSource;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpBalancerListener implements Runnable {
    private static final int PACKET_SIZE = 1024;
    ServerSource serverSource;
    int udpFromBalancerPort;

    public UdpBalancerListener(ServerSource serverSource, int udpFromBalancerPort) {
        this.serverSource = serverSource;
        this.udpFromBalancerPort = udpFromBalancerPort;
    }


    @Override
    public void run() {
        DatagramSocket serverUdpSocket;
        try {
            serverUdpSocket = new DatagramSocket(udpFromBalancerPort);
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }

        byte[] dataIn = new byte[PACKET_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, PACKET_SIZE);

        try {
            while (true) {
                serverUdpSocket.receive(packetIn);
                String line = new String(dataIn, 0, packetIn.getLength());
                handleDataFromBalancer(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void handleDataFromBalancer(String line) {
        String[] parts = line.split(":");
        String host = parts[0];
        int port = Integer.parseInt(parts[1]);

        ServerData data = new ServerData(host, port);
        serverSource.update(data);
    }
}
