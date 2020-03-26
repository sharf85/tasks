package com.telran.handler;

import java.net.DatagramPacket;

public class HandlerDataReceiver implements Runnable {

    private DatagramPacket incomingPacket;
    private HandlerPriorityQueue servers;

    public static final String DELIMITER = ":";

    public HandlerDataReceiver(
            DatagramPacket incomingPacket,
            HandlerPriorityQueue servers) {
        this.incomingPacket = incomingPacket;
        this.servers = servers;
    }

    @Override
    public void run() {
        HandlerServer server = parseHandlerData(incomingPacket);
        servers.update(server);
    }

    HandlerServer parseHandlerData(DatagramPacket incomingPacket) {
        String data = new String(
                incomingPacket.getData(),
                0,
                incomingPacket.getLength());

        // the data comes in the following format: "port:load"
        String[] parts = data.split(DELIMITER);

        String ip = incomingPacket.getAddress().getHostAddress();
        int port = Integer.parseInt(parts[0]);
        int load = Integer.parseInt(parts[1]);

        return new HandlerServer(port, ip, load);
    }
}
