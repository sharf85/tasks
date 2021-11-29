package de.telran;

public class Main {

    public static void main(String[] args) {
        IConcatenator stringConcatenator = new StringConcatenator();
        IConcatenator sBufferConcatenator = new StringBufferConcatenator();
        IConcatenator sBuilderConcatenator = new StringBuilderConcatenator();
        IConcatenator charsConcatenator = new CharsConcatenator();

        ConcatenationTester tester = new ConcatenationTester();

        System.out.println(tester.test(stringConcatenator, "Hello world", 10000));
        System.out.println(tester.test(sBufferConcatenator, "Hello world", 1000000));
        System.out.println(tester.test(sBuilderConcatenator, "Hello world", 1000000));
        System.out.println(tester.test(charsConcatenator, "Hello world", 1000000));
    }
}
