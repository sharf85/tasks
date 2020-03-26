package com.telran.validator;

public interface ValidationRule<E> {
    public void matches(E o) throws BreakRuleException;
}
