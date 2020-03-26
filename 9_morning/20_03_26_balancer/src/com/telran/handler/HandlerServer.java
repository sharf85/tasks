package com.telran.handler;

import java.time.LocalDateTime;
import java.util.Objects;

public class HandlerServer implements Comparable<HandlerServer> {

    private int port;
    private String ip;
    private int load;
    private LocalDateTime dateTime;

    public HandlerServer(int port, String ip, int load) {
        this.port = port;
        this.ip = ip;
        this.load = load;
        dateTime = LocalDateTime.now();
    }

    @Override
    public int compareTo(HandlerServer other) {
        return Integer.compare(this.load, other.load);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerServer that = (HandlerServer) o;
        return port == that.port &&
                Objects.equals(ip, that.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(port, ip);
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    public int getLoad() {
        return load;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return ip + ":" + port;
    }
}
