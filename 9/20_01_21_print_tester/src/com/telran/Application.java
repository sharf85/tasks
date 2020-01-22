package com.telran;

import com.telran.printer.PrintStreamAdapter;
import com.telran.printer.PrintWriterAdapter;

import java.io.PrintWriter;

public class Application {

    public static void main(String[] args) {

        PrintStreamAdapter psa = new PrintStreamAdapter(System.out);
        PrintWriterAdapter pwa = new PrintWriterAdapter(new PrintWriter(System.out, true));
        String testLine = "Hello World!";
        int numOfLines = 1000;

        PrintTester psaTest = new PrintTester(psa);
        PrintTester pwaTest = new PrintTester(pwa);

        long speedOfPsa = psaTest.testPrintPerformance(testLine, numOfLines);
        long speedOfPwa = pwaTest.testPrintPerformance(testLine, numOfLines);

        System.out.println("\nВремя вывода методом PrintStream: " + speedOfPsa);
        System.out.println("Время вывода методом PrintWriter: " + speedOfPwa);

        long difference = speedOfPsa / speedOfPwa;
        System.err.println("\nМетод PrintWriter в " + difference + " раз быстрее чем метод PrintStream.");
        //Просто красненьким вывести захотелось!
    }

}
