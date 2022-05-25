package de.telran.spring_load_balancer_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Server implements CommandLineRunner {

    private final LoadSender loadSender;
    private final TcpServer tcpServer;

    public Server(LoadSender loadSender, TcpServer tcpServer) {
        this.loadSender = loadSender;
        this.tcpServer = tcpServer;
    }


    @Override
    public void run(String... args) throws Exception {
        tcpServer.run();
        loadSender.run();
        System.out.println("Threads started");
    }
}
