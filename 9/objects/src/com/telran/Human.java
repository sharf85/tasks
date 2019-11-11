package com.telran;

public class Human {
    static int numberOfHumans = 0;

    Human() {
        numberOfHumans++;
    }

    Human(String nameIn, String surnameIn, int ageIn) {
        numberOfHumans++;
        name = nameIn;
        surname = surnameIn;
        age = ageIn;
    }

    String name;
    String surname;
    int age;

    void introduce() {
        System.out.println("Hello, my name is " + name + " " + surname + ". I am " + age + ".");
    }
}


