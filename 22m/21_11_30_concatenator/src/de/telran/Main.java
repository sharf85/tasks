package de.telran;

public class Main {

    public static void main(String[] args) {
        ConcatenationTester tester = new ConcatenationTester();
        IConcatenator stringConcat = new StringConcatenator();
        IConcatenator stringBuilderConcat = new StringBuilderConcatenator();
        IConcatenator stringBufferConcat = new StringBufferConcatenator();
        IConcatenator charArrayConcat = new CharArrayConcatenator();

        System.out.println(tester.test(stringConcat, "Hello world guys", 100000));
        System.out.println(tester.test(stringBuilderConcat, "Hello world guys", 100000));
        System.out.println(tester.test(stringBufferConcat, "Hello world guys", 100000));
        System.out.println(tester.test(charArrayConcat, "Hello world guys", 100000));
    }
}
