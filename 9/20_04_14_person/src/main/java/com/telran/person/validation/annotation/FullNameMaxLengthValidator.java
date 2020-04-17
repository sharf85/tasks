package com.telran.person.validation.annotation;

import com.telran.person.dto.PersonDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FullNameMaxLengthValidator implements ConstraintValidator<FullNameMaxLength, PersonDto> {

    int maxLength;

    public void initialize(FullNameMaxLength constraint) {
        maxLength = constraint.value();
    }

    public boolean isValid(PersonDto obj, ConstraintValidatorContext context) {
        return obj.firstName.length() + obj.lastName.length() < maxLength;
    }
}
