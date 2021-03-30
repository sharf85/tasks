package de.telran.hello_web.dto;

//Data transfer object
public class Greetings {

    public Greetings() {
    }

    public Greetings(String name, String greetings) {
        this.name = name;
        this.greetings = greetings;
    }

    public String name;

    public String greetings;

    @Override
    public String toString() {
        return greetings + " " + name;
    }
}
