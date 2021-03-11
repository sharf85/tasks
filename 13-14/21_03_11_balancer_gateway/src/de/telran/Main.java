package de.telran;

import de.telran.server.ServerSource;

import java.io.IOException;

public class Main {

    private static final String DEFAULT_PROPS_PATH = "config/application.props";
    private static final String TCP_OUTER_PORT_KEY = "tcp.outer.port";
    private static final String UDP_FROM_BALANCER_PORT_KEY = "udp.balancer.port";

    public static void main(String[] args) throws IOException {
        String propsPath = args.length > 0 ? args[0] : DEFAULT_PROPS_PATH;
        ApplicationProperties properties = new ApplicationProperties(propsPath);

        int tcpOuterPort = Integer.parseInt(properties.getProperty(TCP_OUTER_PORT_KEY));
        int udpFromBalancerPort = Integer.parseInt(properties.getProperty(UDP_FROM_BALANCER_PORT_KEY));

        ServerSource serverSource = new ServerSource();
        TcpOuterListener tcpOuterListener = new TcpOuterListener(serverSource, tcpOuterPort);
        UdpBalancerListener udpBalancerListener = new UdpBalancerListener(serverSource, udpFromBalancerPort);

        new Thread(tcpOuterListener).start();
        new Thread(udpBalancerListener).start();
    }
}
