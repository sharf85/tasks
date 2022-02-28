package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        //Runnable
        EchoMessenger messenger = new EchoMessenger();
        Thread messengerThread = new Thread(messenger);
        messengerThread.setDaemon(true);
        messengerThread.start();

        //Thread
        EchoMessengerThread echoMessengerThread = new EchoMessengerThread();
        echoMessengerThread.setDaemon(true);
        echoMessengerThread.start();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                messenger.setMessage(line);
                echoMessengerThread.setMessage(line);
                messengerThread.interrupt();
                echoMessengerThread.interrupt();
            }
        }

    }
}
