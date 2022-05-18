package com.example.spring_load_balancer.thread;

import com.example.spring_load_balancer.model.ServerData;
import com.example.spring_load_balancer.repo.IServerMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@Component
public class UdpGatewaySender {
    private final String host;
    private final IServerMap serverMap;
    private final int udpToGatewayPort;
    private final int periodMillis;


    public UdpGatewaySender(@Value("${gateway.host}") String host,
                            IServerMap serverMap,
                            @Value("${udp.gateway.port}") int udpToGatewayPort,
                            @Value("${udp.gateway.sender.period}") int periodMillis) {
        this.host = host;
        this.serverMap = serverMap;
        this.udpToGatewayPort = udpToGatewayPort;
        this.periodMillis = periodMillis;
    }

    @Async("threadExecutor")
    public void run() {
        System.out.println("Udp gateway sender");
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
