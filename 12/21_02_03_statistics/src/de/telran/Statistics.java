package de.telran;

import java.time.LocalDateTime;

public class Statistics {

    private String url;
    private LocalDateTime time;

    public Statistics(LocalDateTime time, String url) {
        this.url = url;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getTime() {
        return time;
    }

}
