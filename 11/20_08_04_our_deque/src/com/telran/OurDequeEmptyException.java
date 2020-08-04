package com.telran;

public class OurDequeEmptyException extends RuntimeException {
    public OurDequeEmptyException() {
        super();
    }

    public OurDequeEmptyException(String message) {
        super(message);
    }

}
