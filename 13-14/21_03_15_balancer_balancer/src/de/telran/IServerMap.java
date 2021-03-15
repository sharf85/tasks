package de.telran;

public interface IServerMap {
    /**
     * update information about server, the more tasks the server has, the higher the load
     */
    void update(ServerData serverData);

    /**
     * @return data about server with less amount of tasks
     */
    ServerData getBest();

    /**
     * removes from data all not updated servers for the last milliseconds
     */
    void removeUnused(int millis);
}
