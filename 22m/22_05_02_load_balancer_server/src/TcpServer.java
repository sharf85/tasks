import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TcpServer implements Runnable {

    private final AtomicInteger loadCounter;
    private final int selfTcpPort;

    private final int connectionsNumber;

    public TcpServer(AtomicInteger loadCounter, int selfTcpPort, int connectionsNumber) {
        this.loadCounter = loadCounter;
        this.selfTcpPort = selfTcpPort;
        this.connectionsNumber = connectionsNumber;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(selfTcpPort)) {
            ExecutorService executorService = Executors.newFixedThreadPool(connectionsNumber);

            while (true) {
                Socket socket = serverSocket.accept();
                loadCounter.incrementAndGet();
                Runnable serverTask = new ServerTask(socket, loadCounter);
                executorService.execute(serverTask);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
