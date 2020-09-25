package com.telran.task;

import com.telran.backend.BackendServerEntity;
import com.telran.backend.IBackendServerStorage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BackendUdpListener implements Runnable {

    private final IBackendServerStorage storage;
    private final int udpPort;

    public BackendUdpListener(IBackendServerStorage storage, int udpPort) {
        this.storage = storage;
        this.udpPort = udpPort;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(udpPort);

            byte[] dataIn = new byte[1024];
            DatagramPacket packetIn = new DatagramPacket(dataIn, dataIn.length);

            while (true) {
                socket.receive(packetIn);
                String body = new String(dataIn, 0, packetIn.getLength());
                BackendServerEntity backend = mapDataToBackend(body);

                // place the data of the backend to the storage
                storage.update(backend);
                System.out.println("Storage size: " + storage.size());
                System.out.println("Accepted backend: " + backend.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BackendServerEntity mapDataToBackend(String body) {
        String[] serverDataAndLoad = body.split("#");
        String[] hostAndPort = serverDataAndLoad[0].split(":");
        BackendServerEntity res = new BackendServerEntity(Integer.parseInt(hostAndPort[1]), hostAndPort[0]);
        res.setLoad(Integer.parseInt(serverDataAndLoad[1]));
        return res;
    }
}
