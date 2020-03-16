package com.telran;

import java.io.*;
import java.net.Socket;

public class Client {

    static final int PORT = 2000;
    static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, PORT);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        PrintStream ps = new PrintStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        while ((line = consoleReader.readLine()) != null && !line.equals("exit")) {
            ps.println(line);
            System.out.println("from the server: " + br.readLine());
        }
        socket.close();
    }
}
