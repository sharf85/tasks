package com.telran.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class FileService {

    private PrintWriter pw;
    private BufferedReader br;

    public FileService(PrintWriter pw, BufferedReader br) {
        this.pw = pw;
        this.br = br;
    }

    public void readFileToQueue(String filename, Collection<String> collection) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null)
                collection.add(line);
        }
    }

    public synchronized void println(String result) {
        pw.println(result);
    }

    public String readLine() throws IOException {
        return br.readLine();
    }
}
