package de.telran.human;

public class Human {

    public Human(String specifiedName, String specifiedSurname, int specifiedAge) {
        name = specifiedName;
        surname = specifiedSurname;
        age = specifiedAge;
    }

    private int age;//field
    private String name;
    private String surname;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void introduce() {
        System.out.println("My name is " + name + " " + surname + ". I am " + age + " years old.");
    }
}

