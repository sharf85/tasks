package com.telran.printer;

import java.io.PrintStream;

public class PrintStreamAdapter implements PrintAdapter {

    private PrintStream ps;

    public PrintStreamAdapter(PrintStream ps) {
        this.ps = ps;
    }

    public void println(String line) {
        ps.println(line);
    }

    public void close() {
        ps.close();
    }
}
