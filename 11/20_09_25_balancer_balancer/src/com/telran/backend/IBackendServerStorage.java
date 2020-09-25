package com.telran.backend;

import java.time.Duration;

/**
 * The data structure stores the information about all the backends appealed to the balancer
 * and also keeps their actual load parameter. The method should be thread safe
 */
public interface IBackendServerStorage {

    /**
     * @return the amount of active backends
     */
    int size();

    /**
     * updates server's load or adds this new backend server if not present
     *
     * @param backend server to add or update
     */
    void update(BackendServerEntity backend);

    /**
     * @return the optimal backend according to the load parameter or 'null' if the storage is empty
     */
    BackendServerEntity getOptimal();

    /**
     * Clears the data structure from inactive backends
     */
    void clearOlderThan(Duration duration);

}
