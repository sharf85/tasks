import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private final static int SERVER_PORT = 3000;

    // Хотим сделать сервер, который открывает поток для каждого входящего соединения и обрабытывает его.
    public static void main(String... args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        // задача этого бесконечного цикла - принять соединение, открыть отдельный поток для его обработки и немеленно
        // продолжить слушать следующее входящее соединение.
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable serverTask = new ServerTask(socket);
            new Thread(serverTask).start();
        }
    }
}
