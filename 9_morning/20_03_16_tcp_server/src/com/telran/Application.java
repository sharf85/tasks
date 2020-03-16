package com.telran;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

    // till 2^16
    static final int PORT = 2000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        Socket socket = server.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        String line;
        while ((line = br.readLine()) != null) {
            ps.println(line + " hello");
        }
        socket.close();
    }
}
