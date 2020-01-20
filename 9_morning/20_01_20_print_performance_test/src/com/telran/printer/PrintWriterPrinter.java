package com.telran.printer;

import java.io.PrintWriter;

public class PrintWriterPrinter implements PrinterInterface {

    PrintWriter pw;

    public PrintWriterPrinter(PrintWriter pw) {
        this.pw = pw;
    }

    public void println(String line) {
        pw.println(line);
    }

    public void close() {
        pw.close();
    }
}
