package com.telran;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        readLinesFromFile();
    }

    public static void readLinesFromConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in;

        while ((in = br.readLine()) != null && !in.equals("exit")) {
            System.out.println(in + " Vasya");
        }

    }

    public static void readLinesFromFile() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("lines.txt"));

        String in;

        while ((in = br.readLine()) != null) {
            System.out.println(in);
        }

    }
}
