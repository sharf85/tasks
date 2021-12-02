package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String str = (String) returnItself("Hello");
        System.out.println(str);
//        String falseString = (String) returnItself(1);// throws ClassCastException

        String hello = "Hello";
        str = returnItselfGenerified(hello);
        System.out.println(str);
//        String falseString = (String) returnItselfGenerified(1); // error while compilation

        GenerifiedClass<String> generified = new GenerifiedClass<>();
        str = generified.returnItselfGenerified("hello");


        List<Double> ints = new ArrayList<>();
        ints.add("hello");
        ints.add(25);
        ints.add(1.5);

    }

    static Object returnItself(Object obj) {
        return obj;
    }

    static <T> T returnItselfGenerified(T obj) {
        return obj;
    }
}

class GenerifiedClass<T> {
    public T returnItselfGenerified(T obj) {
        return obj;
    }
}

class OurInteger {
    private final int value;

    public OurInteger(int value) {
        this.value = value;
    }

    public static OurInteger valueOf(int number) {
        return new OurInteger(number);
    }

    public int getValue() {
        return value;
    }
}
