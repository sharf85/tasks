package de.telran;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        printWriter();
        printStream();
    }

    public static void printWriter() throws IOException {
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintWriter pw = new PrintWriter(fos);
//        PrintWriter pw = new PrintWriter("output.txt");

        pw.println("Hello");
        pw.println("Hello");
        pw.println("Hello");

        // commit collected data
        pw.flush();

        pw.println("Hello");
        pw.println("Hello");
        pw.println("Hello2");

        fos.write("sdfsd".getBytes());// throws
        // commit collected data
        pw.close();// after this string the pw and fos do not work

        pw.println("sdf");// does not throw
//        fos.write("sdfsd".getBytes());// throws
    }

    public static void printStream() throws IOException {
        FileOutputStream fos = new FileOutputStream("output2.txt");
        PrintStream ps = new PrintStream(fos);

        ps.println("Hello");
        ps.println("Hello");
        ps.println("Hello");
        ps.println("Hello");
        ps.println("Hello");
        ps.println("Hello2");
    }
}
