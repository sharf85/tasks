package com.telran;

import java.io.*;
import java.net.Socket;

public class Main {

    static final String SERVER_HOST = "localhost";
    static final int SERVER_PORT = 5000;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_HOST, SERVER_PORT);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        // the object sends data to server
        PrintStream socketOut = new PrintStream(socket.getOutputStream());
        // the object receives data from server
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;

        // reads lines from the console until "exit" appears
        while ((line = consoleReader.readLine()) != null && !line.equals("exit")) {
            // sends the line to the server
            socketOut.println(line);

            // waiting for the response from the server
            String response = socketIn.readLine();
            System.out.println(response);
        }

        socket.close();
    }
}
