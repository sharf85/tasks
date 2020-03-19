package com.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {

    static final int INCOMING_DATAGRAM_SIZE = 1024;
    static final int PORT = 3000;

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(PORT);
//        InetAddress ip = InetAddress.getByName("localhost");

        while (true) {
            byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);
            socket.receive(incomingPacket);

            String line = new String(incomingData, 0, incomingPacket.getLength());
            line = "Hello from UDP server: " + line;

            DatagramPacket outgoingPacket = new DatagramPacket(
                    line.getBytes(),
                    line.length(),
                    incomingPacket.getAddress(),
                    incomingPacket.getPort());

            socket.send(outgoingPacket);
        }
    }
}
