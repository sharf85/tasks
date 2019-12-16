package com.telran;

import com.telran.tester.BuilderConcatenator;
import com.telran.tester.ConcatStringsTester;
import com.telran.tester.ConcatenatorInterface;
import com.telran.tester.StringConcatenator;

public class Application {

    public static void main(String[] args) {
        ConcatStringsTester tester = new ConcatStringsTester();

        ConcatenatorInterface stringConcatenator = new StringConcatenator();
        ConcatenatorInterface builderConcatenator = new BuilderConcatenator();

        System.out.println(tester.test(10000, "hello", stringConcatenator));
        System.out.println(tester.test(10000, "hello", builderConcatenator));

    }
}
