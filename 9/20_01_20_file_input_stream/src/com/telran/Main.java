package com.telran;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("file.txt");
        int length = fis.available();
        byte[] input = new byte[length];
        fis.read(input);

        System.out.println(Arrays.toString(input));
        System.out.println(new String(input));
        fis.close();
    }
}
