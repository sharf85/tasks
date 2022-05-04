import storage.ServerStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServer implements Runnable{
    private final int selfTcpPort;
    private final int connectionsNumber;
    private final ServerStorage serverStorage;

    public TcpServer(int selfTcpPort, int connectionsNumber, ServerStorage serverStorage) {
        this.selfTcpPort = selfTcpPort;
        this.connectionsNumber = connectionsNumber;
        this.serverStorage = serverStorage;
    }

    @Override
    public void run() {
        try(ServerSocket clientSocket = new ServerSocket(selfTcpPort)){
            ExecutorService executorService = Executors.newFixedThreadPool(connectionsNumber);

            while(true){
                Socket socket = clientSocket.accept();
                Runnable task = new TcpServerTask(socket, serverStorage);
                executorService.execute(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
