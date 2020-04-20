package com.telran.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.person.validation.annotation.FullName;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@FullName(10)
public class PersonDto {

    public PersonDto() {
    }

    public PersonDto(int id,
                     String firstName,
                     String lastName,
                     LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    @Min(0)
    public int id;

    @Size(max = 10, min = 1, message = "The name '${validatedValue}' is shorter than {min} or longer than {max}")
    public String firstName;

    @Size(min = 2, max = 20)
    public String lastName;

    @JsonFormat(pattern = "yyyy.MM.dd")
    public LocalDate birthday;

    public List<NumberDto> numbers;

}
