package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class TcpRequest implements Runnable {

    private String outerServerHost;
    private int outerSeverPort;
    private String message;
    private static AtomicInteger counter = new AtomicInteger();

    public TcpRequest(String outerServerHost, int outerSeverPort, String message) {
        this.outerServerHost = outerServerHost;
        this.outerSeverPort = outerSeverPort;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(outerServerHost, outerSeverPort);

            PrintStream streamOut = new PrintStream(socket.getOutputStream());
            BufferedReader streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            streamOut.println(message);
            String line = streamIn.readLine();
            System.out.println(line);
            socket.close();
//            System.out.println(counter.incrementAndGet());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
