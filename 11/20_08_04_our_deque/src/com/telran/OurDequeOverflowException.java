package com.telran;

public class OurDequeOverflowException extends RuntimeException {

    public OurDequeOverflowException() {
        super();
    }

    public OurDequeOverflowException(String message) {
        super(message);
    }
}
