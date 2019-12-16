package com.telran;

public class Application {

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (A a) {
            System.out.println("catches A");
        } catch (B b) {
            System.out.println("catches B");
        }
    }

    public static void someMethod() throws A, B {
        try {
            throw new A();
        } finally {
            System.out.println("under final");
            throw new B();
        }

    }
}

class A extends Exception {
}

class B extends Exception {
}

