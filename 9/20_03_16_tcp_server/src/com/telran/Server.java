package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    final static int PORT = 3000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

//        while(true){
//            Socket socket = server.accept();
//
//            //the handling thread should open here.
//        }

        Socket socket = server.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        String line;
        while ((line = br.readLine()) != null) {
            line = "hello " + line;
            ps.println(line);
        }

        socket.close();
    }
}
