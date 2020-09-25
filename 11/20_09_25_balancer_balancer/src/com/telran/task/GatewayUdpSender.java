package com.telran.task;

import com.telran.backend.BackendServerEntity;
import com.telran.backend.IBackendServerStorage;

import java.io.IOException;
import java.net.*;

public class GatewayUdpSender implements Runnable {

    final private String gatewayHost;
    final private int udpGatewayPort;
    private final IBackendServerStorage storage;
    private final int sendingPeriodMillis;

    public GatewayUdpSender(String gatewayHost,
                            int udpGatewayPort,
                            IBackendServerStorage storage,
                            int sendingPeriodMillis) {
        this.gatewayHost = gatewayHost;
        this.udpGatewayPort = udpGatewayPort;
        this.storage = storage;
        this.sendingPeriodMillis = sendingPeriodMillis;
    }

    @Override
    public void run() {
        try {
            InetAddress serverAddress = InetAddress.getByName(gatewayHost);

            // reserves a port for sending and receiving datagrams
            DatagramSocket socket = new DatagramSocket();

            while (true) {
                try {
                    Thread.sleep(sendingPeriodMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                BackendServerEntity optimalBackend = storage.getOptimal();
                if (optimalBackend == null)
                    continue;

                byte[] dataOut = storage.getOptimal().toString().getBytes();
                DatagramPacket packetOut = new DatagramPacket(
                        dataOut,
                        dataOut.length,
                        serverAddress,
                        udpGatewayPort
                );

                socket.send(packetOut);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
