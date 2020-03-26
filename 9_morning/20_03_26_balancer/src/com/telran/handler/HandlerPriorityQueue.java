package com.telran.handler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class HandlerPriorityQueue {

    PriorityQueue<HandlerServer> servers;

    public HandlerPriorityQueue() {
        servers = new PriorityQueue<>();
    }

    public void update(HandlerServer server) {
        servers.remove(server);
        servers.add(server);
    }

    public HandlerServer getOptimal() {
        return servers.peek();
    }

    public void removeUnused(Duration duration) {
        LocalDateTime now = LocalDateTime.now();

        servers = servers.stream()
                .filter(server -> server
                        .getDateTime()
                        .isAfter(now.minus(duration)))
                .collect(Collectors.toCollection(PriorityQueue::new));
    }
}
