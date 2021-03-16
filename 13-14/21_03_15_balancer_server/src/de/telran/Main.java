package de.telran;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final String DEFAULT_PROPS_PATH = "config/application.props";
    private static final String UDP_BALANCER_PORT_KEY = "udp.balancer.port";
    private static final String BALANCER_HOST_KEY = "balancer.host";
    private static final String LOAD_TIME_INTERVAL_KEY = "load.time.interval";

    public static void main(String[] args) throws IOException {
        int selfTcpPort = Integer.parseInt(args[0]);

        String propsPath = args.length > 1 ? args[1] : DEFAULT_PROPS_PATH;
        ApplicationProperties properties = new ApplicationProperties(propsPath);

        AtomicInteger connectionCounter = new AtomicInteger();

        TcpGatewayListener tcpGatewayListener = new TcpGatewayListener(selfTcpPort, connectionCounter);
        new Thread(tcpGatewayListener).start();

        String balancerHost = properties.getProperty(BALANCER_HOST_KEY);
        int udpBalancerPort = Integer.parseInt(properties.getProperty(UDP_BALANCER_PORT_KEY));
        int sendInterval = Integer.parseInt(properties.getProperty(LOAD_TIME_INTERVAL_KEY));
        UdpLoadSender loadSender = new UdpLoadSender(balancerHost, udpBalancerPort, connectionCounter, sendInterval, selfTcpPort);
        new Thread(loadSender).start();
    }
}
