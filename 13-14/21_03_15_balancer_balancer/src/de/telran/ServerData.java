package de.telran;

import java.time.LocalDateTime;
import java.util.Objects;

public class ServerData {
    private final String host;
    private final int port;
    private final int load;
    private final LocalDateTime timeLastUpdate = LocalDateTime.now();

    public ServerData(String host, int port, int load) {
        this.host = host;
        this.port = port;
        this.load = load;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public LocalDateTime getTimeLastUpdate() {
        return timeLastUpdate;
    }

    public int getLoad() {
        return load;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServerData)) return false;
        ServerData that = (ServerData) o;
        return Objects.equals(host, that.host) && Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }

    @Override
    public String toString() {
        return host + ":" + port;
    }
}
