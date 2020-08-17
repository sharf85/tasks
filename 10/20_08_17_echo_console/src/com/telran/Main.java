package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        LinePrinter lp = new LinePrinter();
        Thread th = new Thread(lp);
        th.setDaemon(true);
        th.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.equals("exit")) {
            lp.setLine(line);
            th.interrupt();
        }
    }
}
