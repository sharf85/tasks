package com.telran;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        readFromConsole();
    }

    public static void readFromConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while ((in = br.readLine()) != null && !in.equals("exit")) {
            System.out.println(in + " Vasya");
        }
        br.close();
    }

    public static void readFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String in;
        while ((in = br.readLine()) != null) {
            System.out.println(in);
        }
        br.close();
    }
}
