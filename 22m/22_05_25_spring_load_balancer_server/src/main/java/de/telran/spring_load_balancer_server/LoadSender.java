package de.telran.spring_load_balancer_server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component()
public class LoadSender {

    private final AtomicInteger loadCounter;
    private final int selfTcpPort;
    private final InetAddress balancerHost;
    private final int balancerUdpPort;
    private final int updatePeriod;

    public LoadSender(AtomicInteger loadCounter,
                      @Value("${de.telran.spring_load_balancer_server.self_tcp_port}") int selfTcpPort,
                      @Value("${de.telran.spring_load_balancer_server.balancer_host}") String balancerHost,
                      @Value("${de.telran.spring_load_balancer_server.balancer_udp_port}") int balancerUdpPort,
                      @Value("${de.telran.spring_load_balancer_server.update_period}") int updatePeriod) throws UnknownHostException {
        this.loadCounter = loadCounter;
        this.selfTcpPort = selfTcpPort;
        this.balancerHost = InetAddress.getByName(balancerHost);
        this.balancerUdpPort = balancerUdpPort;
        this.updatePeriod = updatePeriod;
    }

    @Async
    public void run() throws IOException, InterruptedException {
        System.out.println("Load Sender started");

        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            while (true) {
                String data = selfTcpPort + ":" + loadCounter.get();
                byte[] bytesOut = data.getBytes();

                DatagramPacket packet = new DatagramPacket(
                        bytesOut,
                        bytesOut.length,
                        balancerHost,
                        balancerUdpPort
                );
                System.out.println(data);
                datagramSocket.send(packet);

                Thread.sleep(updatePeriod);
            }
        }

    }
}
