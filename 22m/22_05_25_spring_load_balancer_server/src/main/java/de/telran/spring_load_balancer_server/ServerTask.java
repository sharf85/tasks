package de.telran.spring_load_balancer_server;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ServerTask {
    private final AtomicInteger loadCounter;

    public ServerTask(AtomicInteger loadCounter) {
        this.loadCounter = loadCounter;
    }

    @Async("serverTaskExecutor")
    public void run(Socket socket) throws IOException {

        try (PrintStream dataOut = new PrintStream(socket.getOutputStream());
             BufferedReader dataIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            String line;
            while ((line = dataIn.readLine()) != null) {
                String response = line + " handled by server";
                dataOut.println(response);
            }
            System.out.println("Socket closed");
        } finally {
            loadCounter.decrementAndGet();
        }
    }
}
