package com.telran;

import com.telran.tester.BuilderConcatenator;
import com.telran.tester.ConcatStringsTester;
import com.telran.tester.ConcatenatorInterface;
import com.telran.tester.StringConcatenator;

public class Application {

    public static void main(String[] args) {

        ConcatenatorInterface stringConcatenator = new StringConcatenator();
        ConcatenatorInterface builderConcatenator = new BuilderConcatenator();

        ConcatStringsTester stringsTester = new ConcatStringsTester(stringConcatenator);
        ConcatStringsTester builderTester = new ConcatStringsTester(builderConcatenator);

        System.out.println(stringsTester.test(100000, "hello"));
        System.out.println(builderTester.test(100000, "hello"));

    }
}
