package com.telran;

public class LogEntry {
    private String url;
    private String user;

    public LogEntry(String url, String user) {
        this.url = url;
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }
}
