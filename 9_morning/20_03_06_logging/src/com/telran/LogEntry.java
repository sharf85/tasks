package com.telran;

public class LogEntry {
    private String url;
    private String username;

    public LogEntry(String url, String username) {
        this.url = url;
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }
}
