package com.telran;

public class Human {
    private static int numberOfHumans = 0;

    String name;
    String surname;
    int age;

    Human() {
        numberOfHumans++;
    }

    Human(String name, String surname, int age) {
        numberOfHumans++;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public static int getNumberOfHumans() {
        return numberOfHumans;
    }

    void introduce() {
        System.out.println("Hello, my name is " + name + " " + surname + ". I am " + age + ".");
    }
}


