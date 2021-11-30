package de.telran;

public class Main {

    public static void main(String[] args) {
        ConcatenationTester tester = new ConcatenationTester();
        IConcatenator stringConcat = new StringConcatenator();

        System.out.println(tester.test(stringConcat, "Hello world guys", 100000));
    }
}
