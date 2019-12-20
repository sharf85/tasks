package com.telran;

public class Application {

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (AException e) {
         } catch (BException e) {
            System.out.println("B");
        }
    }

    public static void someMethod() throws AException, BException {
        try {
            throw new AException();
        } finally {
            throw new BException();
        }
    }
}

class AException extends Exception {
}

class BException extends Exception {
}

