package de.telran.balancer_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class TcpOuterListener {
    private final int tcpOuterPort;
    private final ServerProxi serverProxi;

    public TcpOuterListener(@Value("${tcp.outer.port}") int tcpOuterPort, ServerProxi serverProxi) {
        this.tcpOuterPort = tcpOuterPort;
        this.serverProxi = serverProxi;
    }

    @Async
    public void run() throws IOException {
        System.out.println("tcp balancer listener");
        ServerSocket serverSocket = new ServerSocket(tcpOuterPort);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            serverProxi.handleConnection(socket);
        }
    }

}
