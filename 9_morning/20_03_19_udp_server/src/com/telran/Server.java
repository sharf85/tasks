//package com.telran;
//
//import java.io.IOException;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//
//public class Server {
//
//    static final int INCOMING_DATAGRAM_SIZE = 1024;
//    static final int PORT = 3000;
//
//    public static void main(String[] args) throws IOException {
//
//        DatagramSocket socket = new DatagramSocket(PORT);
//
//        while (true) {
//            byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];
//            DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);
//            socket.receive(incomingPacket);
//
//            String line = new String(incomingData, 0, incomingPacket.getLength());
//            line = "Hello from UDP server: " + line;
//
//
//            System.out.println(incomingPacket.getPort());
//            DatagramPacket outgoingPacket = new DatagramPacket(
//                    line.getBytes(),
//                    line.length(),
//                    incomingPacket.getAddress(),
//                    incomingPacket.getPort());
//
//            socket.send(outgoingPacket);
//        }
//    }
//}

package com.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int INCOMING_DATAGRAM_SIZE = 1024;
    private static final int PORT = 3000;


    public static void main(String[] args) throws IOException {
        // write your code here
        DatagramSocket udpServer = new DatagramSocket(PORT);
        ExecutorService executor = Executors.newFixedThreadPool(10);


        while (true) {
            byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);
            //received a datagram
            udpServer.receive(incomingPacket);

            ServerTask task = new ServerTask(udpServer, incomingPacket);
            executor.execute(task);
        }
    }
}

class ServerTask implements Runnable {
    private DatagramSocket socket;
    private DatagramPacket incomingPacket;

    public ServerTask(DatagramSocket socket, DatagramPacket incomingPacket) {
        this.socket = socket;
        this.incomingPacket = incomingPacket;
    }

    @Override
    public void run() {
        try {
            String line = new String(incomingPacket.getData(), 0, incomingPacket.getLength());
            line = "Hello from UDP server " + line;

            DatagramPacket outgoingPacket = new DatagramPacket(
                    line.getBytes(),
                    line.length(),
                    incomingPacket.getAddress(),
                    incomingPacket.getPort()
            );

            socket.send(outgoingPacket);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}