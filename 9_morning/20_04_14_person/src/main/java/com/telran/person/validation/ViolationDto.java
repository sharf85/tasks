package com.telran.person.validation;

public class ViolationDto {

    public String fieldName;

    public String message;

    public ViolationDto(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
