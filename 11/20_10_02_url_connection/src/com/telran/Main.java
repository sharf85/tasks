package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

    static final String URL_ADDRESS = "http://evgvvvveny.de";

    public static void main(String[] args) throws IOException {
        URL url = new URL(URL_ADDRESS);

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
