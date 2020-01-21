package com.telran;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        PrintWriter pw = new PrintWriter("file.txt");
        PrintWriter pw = new PrintWriter(System.out);
        PrintStream ps = new PrintStream(System.out);
        pw.println("hello");
        pw.println("hello");
        pw.println("hello");
        pw.println("hello");
        pw.println("hello");
        pw.flush();
        pw.println("world");
        pw.println("world");
        pw.println("world");
        pw.println("world");
        pw.println("world");
//        pw.close();
    }
}
