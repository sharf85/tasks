package com.telran.validator;

import java.util.ArrayList;
import java.util.List;

public class FieldValidator<T> {
    private List<ValidationRule<T>> rules;

    private List<String> messages = new ArrayList<String>();

    public FieldValidator(List<ValidationRule<T>> rules) {
        this.rules = rules;
    }

    public boolean isValid(T o) {
        boolean res = true;

        messages.clear();

        for (ValidationRule<T> rule : rules) {
            try {
                rule.matches(o);
            } catch (BreakRuleException e) {
                res = false;
                messages.add(e.getMessage());
            }
        }
        return res;
    }

    public List<String> getMessages() {
        return new ArrayList<String>(messages);
    }
}
