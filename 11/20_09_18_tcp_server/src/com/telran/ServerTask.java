package com.telran;

import java.net.Socket;

public class ServerTask extends Thread {

    Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
