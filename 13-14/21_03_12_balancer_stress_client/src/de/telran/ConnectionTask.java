package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

class ConnectionTask implements Runnable {

    private final String gatewayHost;
    private final int gatewayPort;
    private final String message;
    private final int messagesNumber;

    public ConnectionTask(String gatewayHost, int gatewayPort, String message, int messagesNumber) {
        this.gatewayHost = gatewayHost;
        this.gatewayPort = gatewayPort;
        this.message = message;
        this.messagesNumber = messagesNumber;
    }

    @Override
    public void run() {
        Socket socket;
        try {
            System.out.println(gatewayHost + ":" + gatewayPort);
            socket = new Socket(gatewayHost, gatewayPort);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedReader fromGateway = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintStream toGateway = new PrintStream(socket.getOutputStream())
        ) {
            for (int i = 0; i < messagesNumber; i++) {
                toGateway.println(message);
                String response = fromGateway.readLine();
                System.out.println(response);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
