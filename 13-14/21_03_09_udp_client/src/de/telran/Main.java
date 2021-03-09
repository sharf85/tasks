package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {

    private final static int UDP_SERVER_PORT = 3000;
    private final static String UDP_SERVER_HOST = "localhost";
    private static final int PACKET_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        // where to to send the datagrams
        InetAddress inetAddress = InetAddress.getByName(UDP_SERVER_HOST);
        // the tool to send and receive datagrams
        DatagramSocket udpSocket = new DatagramSocket();

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = consoleReader.readLine()) != null && !line.equals("exit")) {
            byte[] outputData = line.getBytes();
            // datagram to send
            DatagramPacket packetOut = new DatagramPacket(
                    outputData,
                    outputData.length,
                    inetAddress,
                    UDP_SERVER_PORT);
            // sending the datagram
            udpSocket.send(packetOut);

            // source to accept the data from server
            byte[] inputData = new byte[PACKET_SIZE];
            DatagramPacket packetIn = new DatagramPacket(inputData, PACKET_SIZE);
            udpSocket.receive(packetIn);

            String fromServer = new String(inputData, 0, packetIn.getLength());
            System.out.println(fromServer);

        }

    }
}
