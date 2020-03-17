package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerTask implements Runnable {
    private Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream socketOutput = new PrintStream(socket.getOutputStream());

            String line;
            while ((line = socketInput.readLine()) != null) {
                line = line + " hello";
                socketOutput.println(line);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
