package com.telran;

import java.io.*;
import java.util.*;

public class FileOperations {

    public List<String> readFileToList(String filename) throws IOException {
        List<String> res = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null)
                res.add(line);

            return res;
        }
    }

    public void writeListToFile(List<String> list, String filename) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (String str : list) {
                pw.println(str);
            }
        }
    }

}
