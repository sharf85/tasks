package com.telran.handler;

public class WrongOperationPathException extends RuntimeException {

    public WrongOperationPathException(Exception e) {
        super(e);
    }
}
