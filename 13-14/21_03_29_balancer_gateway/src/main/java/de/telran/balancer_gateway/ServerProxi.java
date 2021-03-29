package de.telran.balancer_gateway;


import de.telran.balancer_gateway.server.ServerData;
import de.telran.balancer_gateway.server.ServerSource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

@Service
public class ServerProxi {

    private final ServerSource serverSource;

    public ServerProxi(ServerSource serverSource) {
        this.serverSource = serverSource;
    }

    @Async
    public void handleConnection(Socket socket) throws IOException {

        ServerData serverData = serverSource.getLast();

        String host = serverData.getHost();
        int port = serverData.getPort();

        // establish connection to the best server
        System.out.println(host + ":" + port);
        Socket socketToServer = new Socket(host, port);

        // proxying to the best server
        try (PrintStream toClient = new PrintStream(socket.getOutputStream());
             BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintStream toServer = new PrintStream(socketToServer.getOutputStream());
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));
        ) {
            String lineFromClient;

            // pipe from client to server
            while ((lineFromClient = fromClient.readLine()) != null) {
                toServer.println(lineFromClient);
                String lineFromServer = fromServer.readLine();
                toClient.println(lineFromServer);
            }
            // close connection to the server
            socketToServer.close();
        }
    }
}
