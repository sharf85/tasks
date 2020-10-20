package de.telran.hellospringweb.dto;

public class HelloDto {

    public String name;

    public String greetings;

    public HelloDto(String name, String greetings) {
        this.name = name;
        this.greetings = greetings;
    }
}
