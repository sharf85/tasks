package de.telran;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String hello = "Hello world!";
        byte[] bytes = hello.getBytes();

        writeBytes(bytes, "output.txt");
    }

    public static void writeBytes(byte[] bytes, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(bytes);
        }

        // old school
//        FileOutputStream fos = new FileOutputStream(filename);
//        try {
//            fos.write(bytes);
//        } finally {
//            fos.close();
//        }
    }
}
