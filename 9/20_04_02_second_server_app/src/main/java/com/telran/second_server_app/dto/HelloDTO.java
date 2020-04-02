package com.telran.second_server_app.dto;

public class HelloDTO {
    private final String name;

    public HelloDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
