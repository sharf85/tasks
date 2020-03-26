package com.telran;

import com.telran.handler.HandlerPriorityQueue;
import com.telran.handler.HandlersListener;

import java.io.IOException;

public class BalancerApplication {

    public static void main(String[] args) throws IOException {

        // the data structure keeping the info about handlers
        HandlerPriorityQueue servers = new HandlerPriorityQueue();

        new HandlersListener(servers).start();
        new HandlersCleaner(servers).start();
        new OuterServerSender(servers).start();
    }
}
