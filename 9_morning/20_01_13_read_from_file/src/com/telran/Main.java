package com.telran;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("temp.txt");
        int length = fis.available();
        byte[] bytes = new byte[length];
        fis.read(bytes);
        fis.close();

        System.out.println(new String(bytes));
    }
}
