package com.telran.verificator;

public class MaxVerificator implements VerificationRule<Integer> {
    private int max;

    public MaxVerificator(int max) {
        this.max = max;
    }

    public void matches(Integer o) throws VerificationException {

    }
}
