package de.telran;

import java.io.IOException;

public class Main {

    private static final String DEFAULT_PROPS_PATH = "config/application.props";
    private static final String UDP_FROM_SERVER_PORT_KEY = "udp.balancer.port";
    private static final String UDP_TO_GATEWAY_PORT_KEY = "udp.gateway.port";
    private static final String GATEWAY_HOST_KEY = "gateway.host";

    public static void main(String[] args) throws IOException {
        String propsPath = args.length > 0 ? args[0] : DEFAULT_PROPS_PATH;
        ApplicationProperties properties = new ApplicationProperties(propsPath);

        int udpServerPort = Integer.parseInt(properties.getProperty(UDP_FROM_SERVER_PORT_KEY));

        IServerMap serverMap = new ServerList();
        UdpServerListener udpServerListener = new UdpServerListener(serverMap, udpServerPort);
        new Thread(udpServerListener).start();

        int udpGatewayPort = Integer.parseInt(properties.getProperty(UDP_TO_GATEWAY_PORT_KEY));
        String gatewayHost = properties.getProperty(GATEWAY_HOST_KEY);
        UdpGatewaySender udpGatewaySender = new UdpGatewaySender(gatewayHost, serverMap, udpGatewayPort, 100);
        new Thread(udpGatewaySender).start();

        Cleaner cleaner = new Cleaner(serverMap, 1000);
        new Thread(cleaner).start();
    }
}
