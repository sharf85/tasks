package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    private final static int SERVER_PORT = 3003;
    private final static String SERVER_HOST = "localhost";
    private static final int DATAGRAM_SIZE = 1024;
//    final static String SERVER_HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverIP = InetAddress.getByName(SERVER_HOST);

        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = consoleInput.readLine()) != null && !line.equals("exit")) {
            byte[] dataOut = line.getBytes();
            DatagramPacket packetOut = new DatagramPacket(
                    dataOut,
                    dataOut.length,
                    serverIP,
                    SERVER_PORT
            );
            socket.send(packetOut);

            byte[] dataReturn = new byte[DATAGRAM_SIZE];
            DatagramPacket packetReturn = new DatagramPacket(dataReturn, DATAGRAM_SIZE);
            socket.receive(packetReturn);

            String res = new String(dataReturn, 0, packetReturn.getLength());
            System.out.println(res);
        }


    }
}
