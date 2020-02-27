package com.telran.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class FileService {

    private PrintWriter pw;

    public FileService(PrintWriter pw) {
        this.pw = pw;
    }

    public void readFileToCollection(String filename, Collection<String> collection) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                collection.add(line);
            }
        }
    }

    public void println(String line) {
        pw.println(line);
    }

}
