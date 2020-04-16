package com.telran.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PersonDto {

    public int id;

    @Size(max = 10, min = 1)
    public String firstName;

    @Size(max = 10, min = 3)
    public String lastName;

    @JsonFormat(pattern = "yyyy.MM.dd")
    public LocalDate birthday;

    public PersonDto() {
    }

    public PersonDto(int id, String firstName, String lastName, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
