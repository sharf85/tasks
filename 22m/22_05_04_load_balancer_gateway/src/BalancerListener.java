import model.Server;
import storage.ServerStorage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class BalancerListener implements Runnable {

    private final int fromBalancerUdpPort;
    private final ServerStorage serverStorage;

    public BalancerListener(int fromBalancerUdpPort, ServerStorage serverStorage) {
        this.fromBalancerUdpPort = fromBalancerUdpPort;
        this.serverStorage = serverStorage;
    }


    @Override
    public void run() {
        try (DatagramSocket datagramSocket = new DatagramSocket(fromBalancerUdpPort)) {
            byte[] data = new byte[1024];
            DatagramPacket packetIn = new DatagramPacket(data, data.length);

            while (true) {
                datagramSocket.receive(packetIn);
                String optimalServerData = new String(data, 0, packetIn.getLength());

                String[] parts = optimalServerData.split(":");
                String serverHost = parts[0];
                int serverPort = Integer.parseInt(parts[1]);

                serverStorage.setServer(new Server(serverHost, serverPort));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
