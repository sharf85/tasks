package com.telran.person.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class PersonDto {

    public PersonDto(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Min(0)
    public int id;

    @Size(max = 10, min = 1)
    public String firstName;

    @Size(min = 2, max = 20)
    public String lastName;

    @Min(18)
    public int age;

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
