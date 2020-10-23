package de.telran.person.dto;

public class PersonDto {

    public PersonDto(int id, String name, String secondName, int age) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }

    public PersonDto() {
    }

    public int id;
    public String name;
    public String secondName;
    public int age;

}
