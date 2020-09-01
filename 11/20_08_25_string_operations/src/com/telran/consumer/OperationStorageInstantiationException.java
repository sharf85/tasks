package com.telran.consumer;

public class OperationStorageInstantiationException extends RuntimeException {
    public OperationStorageInstantiationException(String message, ReflectiveOperationException e) {
        super(message, e);
    }
}
