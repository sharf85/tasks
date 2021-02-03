package de.telran;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> text = readFromConsole();
        writeToFile("output.txt", text);

    }

    public static List<String> readFromConsole() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> res = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null && !line.equals("exit")) {
                res.add(line);
            }

            return res;
        }
    }

    public static void writeToFile(String file, List<String> text) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            for (String line : text) {
                pw.println(line);
            }
        }
    }
}
