package com.telran.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.person.validation.annotation.FullNameMaxLength;
import com.telran.person.validation.annotation.NonYoungerThan;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@FullNameMaxLength(15)
@NoArgsConstructor
public class PersonDto {

    public int id;

    @Size(max = 10, min = 1, message = "{com.telran.person.first_name.validation.message}")
    public String firstName;

    @Size(max = 10, min = 3)
    public String lastName;

    @JsonFormat(pattern = "yyyy.MM.dd")
    @NonYoungerThan(20)
    public LocalDate birthday;

    public List<NumberDto> numbers;

    public PersonDto(int id, String firstName, String lastName, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }
}
