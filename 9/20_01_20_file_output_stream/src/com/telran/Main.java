package com.telran;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("file.txt", true);
        String str = "Hello file!";
        byte[] output = str.getBytes();
        fos.write(output);
        fos.close();
    }
}
