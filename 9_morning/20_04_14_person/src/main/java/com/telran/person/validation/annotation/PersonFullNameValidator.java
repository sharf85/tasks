package com.telran.person.validation.annotation;

import com.telran.person.dto.PersonDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonFullNameValidator implements ConstraintValidator<FullName, PersonDto> {

    int maxLength;

    public void initialize(FullName constraint) {
        maxLength = constraint.value();
    }

    public boolean isValid(PersonDto obj, ConstraintValidatorContext context) {
        return obj.firstName.length() + obj.lastName.length() < maxLength;
    }
}
