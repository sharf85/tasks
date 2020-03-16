package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    final static int PORT = 3000;
    final static String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, PORT);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        PrintStream socketOutput = new PrintStream(socket.getOutputStream());
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        while ((line = consoleReader.readLine()) != null && !line.equals("exit")) {
            socketOutput.println(line);
            line = socketInput.readLine();
            System.out.println("Response from server: " + line);
        }
        socket.close();
    }
}
