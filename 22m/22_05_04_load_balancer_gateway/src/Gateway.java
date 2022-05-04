import storage.ServerStorage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Gateway {

    private static final String DEFAULT_PROPS_FILE = "config/application.props";

    private static final String SELF_TCP_PORT_KEY = "tcp.outer.port";
    private static final String UPD_BALANCER_INBOUND_PORT_KEY = "udp.balancer.inbound.port";
    private static final String TCP_CONNECTION_NUMBER_KEY = "tcp.connections.number";

    public static void main(String[] args) throws IOException {
        String propsFilename = args.length > 0 ? args[0] : DEFAULT_PROPS_FILE;

        Properties props = new Properties();
        props.load(new FileReader(propsFilename));

        int selfTcpPort = Integer.parseInt(props.getProperty(SELF_TCP_PORT_KEY));
        int fromBalancerUdpPort = Integer.parseInt(props.getProperty(UPD_BALANCER_INBOUND_PORT_KEY));
        int connectionsNumber = Integer.parseInt(props.getProperty(TCP_CONNECTION_NUMBER_KEY));

        ServerStorage serverStorage = new ServerStorage();

        BalancerListener balancerListener = new BalancerListener(fromBalancerUdpPort, serverStorage);
        new Thread(balancerListener).start();

        TcpServer tcpServer = new TcpServer(selfTcpPort, connectionsNumber, serverStorage);
        new Thread(tcpServer).start();
    }
}
