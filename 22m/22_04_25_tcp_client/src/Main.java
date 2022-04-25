import java.io.*;
import java.net.Socket;

public class Main {

    private final static String SERVER_HOST = "localhost";
    private final static int SERVER_PORT = 3000;

    public static void main(String... args) throws IOException {
        Socket socket = new Socket(SERVER_HOST, SERVER_PORT);

        PrintStream dataOut = new PrintStream(socket.getOutputStream());
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = fromConsole.readLine()) != null && !line.equals("exit")) {
            dataOut.println(line);
            String response = dataIn.readLine();
            System.out.println(response);
        }
        socket.close();
    }
}
