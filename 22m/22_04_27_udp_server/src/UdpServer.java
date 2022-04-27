import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {

    private final static int PORT = 4000;
    private final static int DATAGRAM_SIZE = 1024;

    public static void main(String... args) throws IOException, InterruptedException {
        DatagramSocket datagramSocket = new DatagramSocket(PORT);

        byte[] input = new byte[DATAGRAM_SIZE];
        DatagramPacket inputPacket = new DatagramPacket(input, DATAGRAM_SIZE);

        while (true) {
            // receive a datagram
            datagramSocket.receive(inputPacket);
            String incomingString = new String(input, 0, inputPacket.getLength());


            Thread.sleep(5000);
            //handle it
            System.out.println(incomingString + " came from " + inputPacket.getAddress() + ":" + inputPacket.getPort());

            //send the response back
            String response = incomingString + " handled by server";
            byte[] responseBytes = response.getBytes();
            DatagramPacket outputPacket = new DatagramPacket(responseBytes,
                    responseBytes.length,
                    inputPacket.getAddress(),
                    inputPacket.getPort());
            datagramSocket.send(outputPacket);
        }
    }
}
