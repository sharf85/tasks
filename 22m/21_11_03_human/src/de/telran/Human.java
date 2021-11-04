package de.telran;

public class Human {

    private String name;
    private String surname;
    private int age;

    public Human(String specifiedName, String specifiedSurname, int specifiedAge) {
        name = specifiedName;
        surname = specifiedSurname;
        age = specifiedAge;
    }

    public void introduce() {
        if (age < 50)
            System.out.println("Hi, my name is " + name + " " + surname + ". I am " + age + " years old.");
        else
            System.out.println("Hello, my name is " + name + " " + surname + ". I am " + age + " years old.");
    }
}

