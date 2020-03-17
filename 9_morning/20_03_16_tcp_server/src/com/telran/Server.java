package com.telran;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    // till 2^16
    static final int PORT = 2000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {

            Socket socket = server.accept();

            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream socketOutput = new PrintStream(socket.getOutputStream());

            String line;
            while ((line = socketInput.readLine()) != null) {
                line = line + " hello";
                socketOutput.println(line);
            }
            socket.close();
        }
        //connection established
    }
}
