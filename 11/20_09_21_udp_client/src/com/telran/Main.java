package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {

    static final String SERVER_HOST = "192.168.2.100";
    static final int SERVER_PORT = 4000;

    public static void main(String[] args) throws IOException {
        InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);
        BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));

        // reserves a port for sending and receiving datagrams
        DatagramSocket socket = new DatagramSocket();

        // the storage for accepting data from the server as a response.
        byte[] dataIn = new byte[1024];
        DatagramPacket packetIn = new DatagramPacket(dataIn, dataIn.length);

        String line;
        while ((line = fromConsole.readLine()) != null && !line.equals("exit")) {
            byte[] dataOut = line.getBytes();
            DatagramPacket packetOut = new DatagramPacket(
                    dataOut,
                    dataOut.length,
                    serverAddress,
                    SERVER_PORT
            );
            socket.send(packetOut);

            socket.receive(packetIn);
            String response = new String(dataIn, 0, packetIn.getLength());
            System.out.println(response);
        }

    }
}
