package com.telran.handler;

public class OperationInitException extends RuntimeException {
    public OperationInitException(Exception e) {
        super(e);
    }
}
