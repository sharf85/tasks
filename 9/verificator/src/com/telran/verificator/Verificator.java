package com.telran.verificator;

import java.util.List;

public class Verificator<T> {
    private List<VerificationRule<T>> rules;

    List messages;

    public Verificator(List<VerificationRule<T>> rules) {
        this.rules = rules;
    }

    public boolean isValid(T o) {
        boolean res = true;

        for (VerificationRule<T> rule : rules) {
            try {
                rule.matches(o);
            } catch (VerificationException e) {
                res = false;
//                messages.addAll()e.getMessage();
            }
        }
        return false;
    }
}
