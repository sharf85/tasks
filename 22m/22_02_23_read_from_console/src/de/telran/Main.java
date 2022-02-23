package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> fromConsole = readFromConsole();
        FileOperations.writeToFile(fromConsole, "output.txt");
    }

    private static List<String> readFromConsole() throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> res = new ArrayList<>();

            String line;
            while ((line = bf.readLine()) != null && !line.equals("exit")) {
                res.add(line);
            }
            return res;
        }
    }
}
