package com.telran.validator.basic;

import com.telran.validator.BreakRuleException;
import com.telran.validator.ValidationRule;

public class MinRule implements ValidationRule<Integer> {

    private int min;

    public MinRule(int min) {
        this.min = min;
    }

    public void matches(Integer o) throws BreakRuleException {

    }
}
