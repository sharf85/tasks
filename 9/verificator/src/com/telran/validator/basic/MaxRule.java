package com.telran.validator.basic;

import com.telran.validator.BreakRuleException;
import com.telran.validator.ValidationRule;

public class MaxRule implements ValidationRule<Integer> {
    private int max;

    public MaxRule(int max) {
        this.max = max;
    }

    public void matches(Integer o) throws BreakRuleException {

    }
}
