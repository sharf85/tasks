package de.telran;

import java.io.*;
import java.net.Socket;

public class Main {

    static int TCP_PORT = 3000;

    public static void main(String[] args) throws IOException {
        // tool for reading console
        BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));

        // create connection to the program listening to 3000 port on the "localhost" machine
        Socket socket = new Socket("localhost", TCP_PORT);

        // tool for sending lines to the 3000 port program
        PrintStream socketOutput = new PrintStream(socket.getOutputStream());
        // tool for receiving responses from the 3000 port program
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        while ((line = fromConsole.readLine()) != null && !line.equals("exit")) {
            socketOutput.println(line);
            String response = socketInput.readLine();

            System.out.println(response);
        }
        socket.close();
    }
}
