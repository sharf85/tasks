package de.telran;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        byte[] bytes = readBytes("input.txt");
        String hello = new String(bytes);
        System.out.println(hello);
    }

    public static byte[] readBytes(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename);) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            return bytes;
        }
    }
}
