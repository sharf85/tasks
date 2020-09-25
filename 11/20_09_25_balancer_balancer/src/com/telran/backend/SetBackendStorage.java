package com.telran.backend;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class SetBackendStorage implements IBackendServerStorage {

    Set<BackendServerEntity> storage;
    BackendLoadComparator comparator;

    public SetBackendStorage() {
        storage = new HashSet<>();
        comparator = new BackendLoadComparator();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public synchronized void update(BackendServerEntity backend) {
        storage.remove(backend);
        storage.add(backend);
    }

    @Override
    public synchronized BackendServerEntity getOptimal() {
        return storage.stream().min(comparator).orElse(null);
    }

    //TODO: complete
    @Override
    public void clearOlderThan(Duration duration) {

    }
}
