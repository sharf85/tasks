package com.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {

    private static final int PORT = 3003;
    private static final int DATA_SIZE = 1024;

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(PORT);

        while (true) {

            //receiving data
            byte[] dataToReceive = new byte[DATA_SIZE];
            DatagramPacket packetIn = new DatagramPacket(dataToReceive, DATA_SIZE);
            socket.receive(packetIn);

            //handling data. Pay Attention on the packetIn.getLength()
            String line = new String(dataToReceive, 0, packetIn.getLength());
            line = "hello " + line;

            //send the data back
            byte[] dataToSendBack = line.getBytes();
            DatagramPacket packetOut = new DatagramPacket(
                    dataToSendBack,
                    dataToSendBack.length,
                    packetIn.getAddress(),
                    packetIn.getPort());

            socket.send(packetOut);

        }


    }
}
