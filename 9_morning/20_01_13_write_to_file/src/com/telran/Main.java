package com.telran;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String hello = "Hello world";
        FileOutputStream fos = new FileOutputStream("temp.txt", true);
        fos.write(hello.getBytes());
        fos.close();
    }
}
