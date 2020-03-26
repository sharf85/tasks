package com.telran.validator.basic;

import com.telran.validator.BreakRuleException;
import com.telran.validator.ValidationRule;

/**
 * The rule verifies whether the length of the string is less than
 * needed
 */
public class MaxLengthRule implements ValidationRule<String> {

    private static final String MESSAGE = "The length of the text is greater than ";

    private int maxLength;

    public MaxLengthRule(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * @param o the string to verify
     * @throws BreakRuleException if the length of the string is
     *                            greater than maxLength
     */
    public void matches(String o) throws BreakRuleException {
        if (o.length() > maxLength)
            throw new BreakRuleException(MESSAGE + maxLength);
    }
}
