package com.telran.validator.basic;

import com.telran.validator.BreakRuleException;
import com.telran.validator.ValidationRule;

public class NotNullRule implements ValidationRule {

    private static final String MESSAGE = "The field is null";

    public void matches(Object o) throws BreakRuleException {
        if (o== null)
            throw new BreakRuleException(MESSAGE);
    }
}
