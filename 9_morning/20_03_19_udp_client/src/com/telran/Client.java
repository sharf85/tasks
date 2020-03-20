package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    private static final int INCOMING_DATAGRAM_SIZE = 1024;
    private static final int SERVER_PORT = 3000;
    private static final String SERVER_HOST = "localhost";
//    private static final String SERVER_HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        DatagramSocket socket = new DatagramSocket();
        InetAddress serverIp = InetAddress.getByName(SERVER_HOST);

        byte[] dataIn = new byte[INCOMING_DATAGRAM_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, INCOMING_DATAGRAM_SIZE);

        String line;
        while ((line = scanner.nextLine()) != null && !line.equals("exit")) {
            byte[] dataOut = line.getBytes();
            DatagramPacket packetOut = new DatagramPacket(
                    dataOut,
                    dataOut.length,
                    serverIp,
                    SERVER_PORT);
            socket.send(packetOut);

            socket.receive(packetIn);
            String res = new String(dataIn, 0, packetIn.getLength());
            System.out.println(res);
        }
        socket.close();

    }
}
