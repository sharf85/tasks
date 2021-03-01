package de.telran.logging;

public class LogEntry {

    String url;
    String login;

    public LogEntry(String login, String url) {
        this.url = url;
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }
}
