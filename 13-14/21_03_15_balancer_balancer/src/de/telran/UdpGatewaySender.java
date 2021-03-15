package de.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpGatewaySender implements Runnable {
    private final String host;
    private final IServerMap serverMap;
    private final int udpToGatewayPort;
    private final int periodMillis;


    public UdpGatewaySender(String host, IServerMap serverMap, int udpToGatewayPort, int periodMillis) {
        this.host = host;
        this.serverMap = serverMap;
        this.udpToGatewayPort = udpToGatewayPort;
        this.periodMillis = periodMillis;
    }

    @Override
    public void run() {
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            DatagramSocket udpSocket = new DatagramSocket();
            while (true) {
                try {
                    Thread.sleep(periodMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ServerData serverData = serverMap.getBest();
                if (serverData == null)
                    continue;

                String best = serverData.toString();

                System.out.println("sending best server to gateway: " + best + ":" + serverData.getLoad());

                byte[] sendBest = best.getBytes();
                DatagramPacket packetOut = new DatagramPacket(
                        sendBest,
                        sendBest.length,
                        inetAddress,
                        udpToGatewayPort
                );

                udpSocket.send(packetOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
