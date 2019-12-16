package com.telran.verificator;

public interface VerificationRule<E> {
    public void matches(E o) throws VerificationException;
}
