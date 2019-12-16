package com.telran;

public class Main {

    public static void main(String[] args) throws A, B {
//        Verificator verificator = new Verificator();

        try {
            throw new Exception();
        } catch (Exception e) {
            throw new A();
        } finally {
            throw new B();
        }

    }
}

class A extends Exception {
}

class B extends Exception {
}

