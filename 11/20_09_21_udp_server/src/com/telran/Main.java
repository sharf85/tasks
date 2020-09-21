package com.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {

    static final int SERVER_PORT = 4000;

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(SERVER_PORT);

        byte[] dataIn = new byte[1024];
        DatagramPacket packetIn = new DatagramPacket(dataIn, dataIn.length);

        while (true) {
            socket.receive(packetIn);
            String body = new String(dataIn, 0, packetIn.getLength());

            String response = InetAddress.getLocalHost().toString() + ":" + SERVER_PORT + " " + body;

            DatagramPacket packetOut = new DatagramPacket(
                    response.getBytes(),
                    response.length(),
                    packetIn.getAddress(),
                    packetIn.getPort()
            );
            socket.send(packetOut);
        }

    }
}
