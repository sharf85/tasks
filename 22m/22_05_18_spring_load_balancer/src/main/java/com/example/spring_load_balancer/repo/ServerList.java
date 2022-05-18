package com.example.spring_load_balancer.repo;

import com.example.spring_load_balancer.model.ServerData;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class ServerList implements IServerMap {

    List<ServerData> source = new ArrayList<>();

    @Override
    public synchronized void update(ServerData serverData) {
        source.remove(serverData);
        source.add(serverData);
    }

    @Override
    public synchronized ServerData getBest() {

        return source.stream()
                .min(Comparator.comparingInt(ServerData::getLoad))
                .orElse(null);
    }


    @Override
    public synchronized void removeUnused(int millis) {
        source.removeIf(serverData ->
                ChronoUnit.MILLIS.between(serverData.getTimeLastUpdate(), LocalDateTime.now()) > millis
        );
    }
}
