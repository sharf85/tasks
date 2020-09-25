package com.telran.backend;

import java.time.ZonedDateTime;
import java.util.Objects;

public class BackendServerEntity {

    int port;
    String host;
    int load;
    ZonedDateTime updateTime;

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public BackendServerEntity(int port, String host) {
        this.port = port;
        this.host = host;
        updateTime = ZonedDateTime.now();
    }

    @Override
    public String toString() {
//        return String.format("%s:%d", host, port);
        return host + ":" + port;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public int getLoad() {
        return load;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackendServerEntity that = (BackendServerEntity) o;
        return port == that.port &&
                Objects.equals(host, that.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(port, host);
    }
}
