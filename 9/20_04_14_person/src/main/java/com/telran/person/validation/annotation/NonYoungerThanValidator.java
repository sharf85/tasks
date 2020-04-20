package com.telran.person.validation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class NonYoungerThanValidator implements ConstraintValidator<NonYoungerThan, LocalDate> {

    private int minAge;

    public void initialize(NonYoungerThan constraint) {
        minAge = constraint.value();
    }

    public boolean isValid(LocalDate birthday, ConstraintValidatorContext context) {
        LocalDate latestBirthday = LocalDate.now().minusYears(minAge);
        return !birthday.isAfter(latestBirthday);
    }
}
