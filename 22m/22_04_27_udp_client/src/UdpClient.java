import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

    private final static int SERVER_PORT = 4000;
    private final static int DATAGRAM_SIZE = 1024;

    public static void main(String... args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InetAddress serverAddress = InetAddress.getByName("localhost");

        byte[] inputBytes = new byte[DATAGRAM_SIZE];
        DatagramPacket inputPacket = new DatagramPacket(inputBytes, DATAGRAM_SIZE);

        String line;
        while ((line = br.readLine()) != null && !line.equals("quit")) {
            // send datagram
            byte[] outputBytes = line.getBytes();
            DatagramPacket outputPacket = new DatagramPacket(
                    outputBytes,
                    outputBytes.length,
                    serverAddress,
                    SERVER_PORT
            );

            datagramSocket.send(outputPacket);
            //waiting for a response datagram
            datagramSocket.receive(inputPacket);
            String response = new String(inputBytes, 0, inputPacket.getLength());
            System.out.println(response);
        }
    }
}
