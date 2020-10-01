package com.telran;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadReporter implements Runnable {

    int loadBalancerPort;
    AtomicInteger socketCounter;
    int period;
    String balancerHost;
    String backendHost;
    int backendPort;

    public LoadReporter(int loadBalancerPort,
                        AtomicInteger socketCounter,
                        int period,
                        String balancerHost,
                        String backendHost,
                        int backendPort) {
        this.loadBalancerPort = loadBalancerPort;
        this.socketCounter = socketCounter;
        this.period = period;
        this.balancerHost = balancerHost;
        this.backendHost = backendHost;
        this.backendPort = backendPort;
    }

    @Override
    public void run() {

        try {
            InetAddress balancerAddress = InetAddress.getByName(balancerHost);
            DatagramSocket socket = new DatagramSocket();

            while (true) {
                Thread.sleep(period);

                String message = backendHost + ":" + backendPort + "#" + socketCounter.get();
                byte[] dataOut = message.getBytes();
                DatagramPacket packetOut = new DatagramPacket(
                        dataOut,
                        dataOut.length,
                        balancerAddress,
                        loadBalancerPort
                );

                socket.send(packetOut);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
