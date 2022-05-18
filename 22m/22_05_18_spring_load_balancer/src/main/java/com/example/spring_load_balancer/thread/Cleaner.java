package com.example.spring_load_balancer.thread;

import com.example.spring_load_balancer.repo.IServerMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Cleaner {
    private final IServerMap serverMap;
    private final int periodMillis;


    public Cleaner(IServerMap serverMap,
                   @Value("${balancer.server.map.cleaner.period}") int periodMillis) {
        this.serverMap = serverMap;
        this.periodMillis = periodMillis;
    }

    @Async("threadExecutor")
    public void run() {
        System.out.println("Cleaner");
        while (true) {
            try {
                Thread.sleep(periodMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            serverMap.removeUnused(periodMillis);
        }
    }
}
