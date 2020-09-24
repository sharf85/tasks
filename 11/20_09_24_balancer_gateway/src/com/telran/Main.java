package com.telran;

public class Main {

    static final int OUTER_TCP_PORT = 5000;
    static final int FROM_BALANCER_UDP_PORT = 5002;

    public static void main(String[] args) {

        //storage for an optimal backend server coordinates
        BackendServerDataStorage serverData = new BackendServerDataStorage();

        //udp balancer listener, which updates serverData
        System.out.println("Load balancer listener run on port " + FROM_BALANCER_UDP_PORT);
        BalancerUdpListener balancerUdpListener = new BalancerUdpListener(serverData, FROM_BALANCER_UDP_PORT);
        Thread balancerThread = new Thread(balancerUdpListener);
        balancerThread.start();

        //the thread, which routes requests from clients to backends
        System.out.println("Tcp proxy run on port " + OUTER_TCP_PORT);
        TcpProxy tcpProxy = new TcpProxy(serverData, OUTER_TCP_PORT);
        Thread proxyThread = new Thread(tcpProxy);
        proxyThread.start();

    }
}
