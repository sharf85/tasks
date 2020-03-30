package com.telran;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Handler {

    private static final int BALANCER_UDP_PORT = 2345;
    private static final String BALANCER_HOST = "localhost";

    public static void main(String[] args) {

        int handlerTcpPort = Integer.parseInt(args[0]);

        AtomicInteger tasksNum = new AtomicInteger();

        new TcpListener(handlerTcpPort, tasksNum).start();

        ScheduledExecutorService udpScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        udpScheduledExecutor.scheduleAtFixedRate(
                new UdpSender(
                        tasksNum,
                        BALANCER_HOST,
                        BALANCER_UDP_PORT,
                        handlerTcpPort
                ),
                0,
                1,
                TimeUnit.SECONDS
        );
    }
}
