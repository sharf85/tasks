package com.telran.printer;

import java.io.PrintStream;

public class PrintStreamPrinter implements PrinterInterface {
    PrintStream ps;

    public PrintStreamPrinter(PrintStream ps) {
        this.ps = ps;
    }

    public void println(String line) {
        ps.println(line);
    }

    public void close() {
        ps.close();
    }
}
