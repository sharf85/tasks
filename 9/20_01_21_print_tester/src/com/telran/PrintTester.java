package com.telran;

import com.telran.printer.PrintAdapter;

public class PrintTester {
    PrintAdapter pa;

    public PrintTester(PrintAdapter pa) {
        this.pa = pa;
    }

    public long testPrintPerformance(String line, int num) {
        long now = System.currentTimeMillis();

        for (int i = 0; i < num; i++) {
            pa.println(line);
        }
        pa.close();

        return System.currentTimeMillis() - now;
    }
}
