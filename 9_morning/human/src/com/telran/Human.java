package com.telran;

public class Human {
    private static int numberOfHumans;

    String name;
    int age;

    public static int getNumberOfHumans() {
        return numberOfHumans;
    }

    public Human(String name, int age) {
        numberOfHumans++;
        this.name = name;
        this.age = age;
    }

    public Human() {
        numberOfHumans++;
    }

    public String introduce() {
        return "My name is " + this.name + ", and I'm " + this.age;
    }
}
