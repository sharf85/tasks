package de.telran;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IPrinter printWriterPrinter = new PrintWriterPrinter();
        IPrinter printStreamPrinter = new PrintStreamPrinter();

        PrinterTester ptWriter = new PrinterTester(printWriterPrinter);
        PrinterTester ptStream = new PrinterTester(printStreamPrinter);

        System.out.println(ptWriter.test("writer.txt", 1048576, "Hello world"));
        System.out.println(ptStream.test("stream.txt", 1048576, "Hello world"));
    }
}
