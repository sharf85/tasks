package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerTask implements Runnable {

    private final Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (PrintStream socketOutput = new PrintStream(socket.getOutputStream());
             BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String line;
            while ((line = socketInput.readLine()) != null) {
                String response = "Handled by server " + line;
                socketOutput.println(response);
            }

            System.out.println("exit socket");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
