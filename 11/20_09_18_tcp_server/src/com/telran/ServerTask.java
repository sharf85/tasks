package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerTask implements Runnable {

    Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // the object sends data to client
            PrintStream socketOut = null;
            socketOut = new PrintStream(socket.getOutputStream());
            // the object receives data from client
            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while ((line = socketIn.readLine()) != null) {
                String response = String.format("The string %s was accepted from the client and handled", line);
                socketOut.println(response);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
