package de.telran;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PrinterTester {

    final IPrinter printer;

    public PrinterTester(IPrinter printer) {
        this.printer = printer;
    }

    // If a class or interface has several methods with the same name, it is called "Static polymorphism"

    /**
     * @param filename where to write
     * @param linesQty the number of lines in the text to test
     * @param line     which composes the text
     * @return time spent
     */
    public long test(String filename, int linesQty, String line) throws IOException {
        List<String> text = createText(linesQty, line);
        return test(filename, text);
    }

    /**
     * @param filename where to write
     * @param text     to write
     * @return time spent
     */
    public long test(String filename, List<String> text) throws IOException {
        long timeBeforeTest = System.currentTimeMillis();
        printer.writeToFile(filename, text);
        return (int) (System.currentTimeMillis() - timeBeforeTest);
    }

    List<String> createText(int linesQty, String line) {
        return Collections.nCopies(linesQty, line);
    }

}
