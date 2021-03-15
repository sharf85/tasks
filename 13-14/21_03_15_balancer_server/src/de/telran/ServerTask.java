package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerTask implements Runnable {

    Socket socket;
    AtomicInteger connectionCounter;

    public ServerTask(Socket socket, AtomicInteger connectionCounter) {
        this.socket = socket;
        this.connectionCounter = connectionCounter;
    }

    @Override
    public void run() {
        try (PrintStream toClient = new PrintStream(socket.getOutputStream());
             BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String lineFromClient;

            // pipe from client to server
            while ((lineFromClient = fromClient.readLine()) != null) {
                String response = "Response from server: " + lineFromClient;
                toClient.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connectionCounter.decrementAndGet();
        }
    }
}
