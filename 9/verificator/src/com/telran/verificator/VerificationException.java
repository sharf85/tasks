package com.telran.verificator;

import java.util.List;

public class VerificationException extends Exception {
    private List<String> messages;

    public VerificationException(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {

        return messages;
    }
}

