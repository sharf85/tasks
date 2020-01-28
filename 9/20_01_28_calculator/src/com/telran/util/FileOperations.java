package com.telran.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    public void listToFile(List<String> content, String outputFilename) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(outputFilename)) {
            for (String line : content) {
                pw.println(line);
            }
        }
    }

    public List<String> fileToList(String inputFilename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilename))) {
            List<String> res = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
            return res;
        }
    }
}
