package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TcpProxyTask implements Runnable {

    private final BackendServerDataStorage serverData;
    Socket clientSocket;

    public TcpProxyTask(BackendServerDataStorage serverData, Socket clientSocket) {
        this.serverData = serverData;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        //establish a connection to the optimal backend server
        try (Socket socketToBackend = new Socket(serverData.getHost(), serverData.getPort())) {

            BufferedReader dataFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintStream dataToClient = new PrintStream(clientSocket.getOutputStream());

            BufferedReader dataFromBackend = new BufferedReader(new InputStreamReader(socketToBackend.getInputStream()));
            PrintStream dataToBackend = new PrintStream(socketToBackend.getOutputStream());

            String line;
            while ((line = dataFromClient.readLine()) != null) {
                dataToBackend.println(line);

                String responseFromBackend = dataFromBackend.readLine();
                dataToClient.println(responseFromBackend);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
