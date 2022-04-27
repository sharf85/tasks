package storage;

import model.Server;

/**
 * Data structure for storing the info about servers
 */
public interface IServerStorage {

    /**
     * adds the server if it was not in the storage, updates the server otherwise.
     * @param server
     */
    public void update(Server server);

    /**
     * Clears the storage from servers which did not update for the recent "milliseconds" time
     * @param milliseconds
     */
    public void clear(int milliseconds);

    /**
     *
     * @return the server which is least loaded at the moment
     */
    public Server getOptimal();

}
