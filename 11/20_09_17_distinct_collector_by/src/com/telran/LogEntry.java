package com.telran;

public class LogEntry {
    String username;
    String url;

    public LogEntry(String username, String url) {
        this.username = username;
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public String getUrl() {
        return url;
    }

}
