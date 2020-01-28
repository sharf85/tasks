package com.telran;

import com.telran.printer.PrintAdapter;
import com.telran.printer.PrintStreamAdapter;
import com.telran.printer.PrintWriterAdapter;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        PrintAdapter psa = new PrintStreamAdapter(new PrintStream("ps.txt"));
        PrintAdapter pwa = new PrintWriterAdapter(new PrintWriter("pw.txt"));

        PrintTester printStreamTester = new PrintTester(psa);
        PrintTester printWriterTester = new PrintTester(pwa);

        System.out.println("Using PrintStream took: " + printStreamTester.testPrintPerformance("Hello", 10000));
        System.out.println("Using PrintWriter took: " + printWriterTester.testPrintPerformance("Hello", 10000));
    }
}
