import java.io.IOException;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadSender implements Runnable {

    private final AtomicInteger loadCounter;
    private final int selfTcpPort;
    private final InetAddress balancerHost;
    private final int balancerUdpPort;
    private final int updatePeriod;

    public LoadSender(AtomicInteger loadCounter, int selfTcpPort, String balancerHost, int balancerUdpPort, int updatePeriod) throws UnknownHostException {
        this.loadCounter = loadCounter;
        this.selfTcpPort = selfTcpPort;
        this.balancerHost = InetAddress.getByName(balancerHost);
        this.balancerUdpPort = balancerUdpPort;
        this.updatePeriod = updatePeriod;
    }


    @Override
    public void run() {

        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            while (true) {
                String data = selfTcpPort + ":" + loadCounter.get();
                byte[] bytesOut = data.getBytes();

                DatagramPacket packet = new DatagramPacket(
                        bytesOut,
                        bytesOut.length,
                        balancerHost,
                        balancerUdpPort
                );
                System.out.println(data);
                datagramSocket.send(packet);

                Thread.sleep(updatePeriod);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
