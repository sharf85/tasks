package com.telran;

public class OuterServer {

    private static final int OUTER_SERVER_TCP_PORT = 3455;
    private static final int OUTER_SERVER_UDP_PORT = 3456;

    public static void main(String[] args) {
        HandlerInfo lastHandler = new HandlerInfo();

        Thread balancerListener = new BalancerListener(OUTER_SERVER_UDP_PORT, lastHandler);
        balancerListener.start();

        Thread tcpListener = new TcpListener(OUTER_SERVER_TCP_PORT, lastHandler);
        tcpListener.start();
    }
}
