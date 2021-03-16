package de.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerListener implements Runnable {
    private static final int PACKET_SIZE = 1024;
    IServerMap serverMap;
    int udpFromServerPort;

    public UdpServerListener(IServerMap serverMap, int udpFromServerPort) {
        this.serverMap = serverMap;
        this.udpFromServerPort = udpFromServerPort;
    }

    @Override
    public void run() {
        DatagramSocket serverUdpSocket;
        try {
            serverUdpSocket = new DatagramSocket(udpFromServerPort);
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }

        byte[] dataIn = new byte[PACKET_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, PACKET_SIZE);

        try {
            while (true) {
                serverUdpSocket.receive(packetIn);
                handleDataFromServer(packetIn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void handleDataFromServer(DatagramPacket packet) {
        String host = packet.getAddress().getHostAddress();

        byte[] bytes = packet.getData();
        String data = new String(bytes, 0, packet.getLength());
        String[] dataParts = data.split(":");

        int port = Integer.parseInt(dataParts[0]);
        int load = Integer.parseInt(dataParts[1]);

        ServerData serverData = new ServerData(host, port, load);
        serverMap.update(serverData);
    }
}
