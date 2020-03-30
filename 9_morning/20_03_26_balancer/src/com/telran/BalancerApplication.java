package com.telran;

import com.telran.handler.HandlerPriorityQueue;
import com.telran.handler.HandlersListener;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BalancerApplication {

    private static final long CLEAR_TIME = 5000;

    public static void main(String[] args) throws IOException {

        // the data structure keeping the info about handlers
        HandlerPriorityQueue servers = new HandlerPriorityQueue();

        new HandlersListener(servers).start();

        Runnable handlersCleaner = () -> servers.removeUnused(Duration.ofMillis(CLEAR_TIME));
        ScheduledExecutorService cleanerExecutor = Executors.newSingleThreadScheduledExecutor();
        cleanerExecutor.scheduleAtFixedRate(
                handlersCleaner,
                0,
                1,
                TimeUnit.SECONDS
        );

        ScheduledExecutorService outerServerExecutor = Executors.newSingleThreadScheduledExecutor();
        outerServerExecutor.scheduleAtFixedRate(
                new OuterServerSender(servers),
                0,
                1,
                TimeUnit.SECONDS
        );
    }
}
