package com.telran.person.dto;

public class NumberDto {
    public int id;

    public String number;

    public int personId;

    public NumberDto(int id, String number, int personId) {
        this.id = id;
        this.number = number;
        this.personId = personId;
    }
}
