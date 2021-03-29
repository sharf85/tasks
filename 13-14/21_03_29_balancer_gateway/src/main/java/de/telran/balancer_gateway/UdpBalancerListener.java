package de.telran.balancer_gateway;

import de.telran.balancer_gateway.server.ServerData;
import de.telran.balancer_gateway.server.ServerSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Component
public class UdpBalancerListener {
    private static final int PACKET_SIZE = 1024;
    ServerSource serverSource;
    int udpFromBalancerPort;

    public UdpBalancerListener(ServerSource serverSource,
                               @Value("${udp.balancer.port}") int udpFromBalancerPort) {
        this.serverSource = serverSource;
        this.udpFromBalancerPort = udpFromBalancerPort;
    }

    @Async
    public void run() throws IOException {
        System.out.println("udp balancer listener");
        DatagramSocket serverUdpSocket;
        serverUdpSocket = new DatagramSocket(udpFromBalancerPort);

        byte[] dataIn = new byte[PACKET_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, PACKET_SIZE);

        while (true) {
            serverUdpSocket.receive(packetIn);
            String line = new String(dataIn, 0, packetIn.getLength());
            handleDataFromBalancer(line);
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
