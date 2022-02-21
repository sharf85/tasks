package de.telran;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    /**
     * Writes the strings into the file, one string as one line
     *
     * @param strings
     * @param filename
     */
    public static void writeToFile(List<String> strings, String filename) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (String string : strings) {
                pw.println(string);
            }
        }
    }

    /**
     * Creates a list of strings based on the file
     *
     * @param filename
     * @return
     */
    public static List<String> readFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
            return res;
        }
    }

    /**
     * Write the numbers into the file so that the file has one string composed from the numbers written one by
     * one with the delimiter " ".
     * <p>
     * {4, 15, -9} -> "4 15 -9"
     *
     * @param numbers
     * @param filename
     */
    public static void writeNumbers(List<Integer> numbers, String filename) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (int number : numbers) {
                pw.print(number);
                pw.print(" ");
            }
        }
    }

    /**
     * "4 15 -9" -> {4, 15, -9}
     *
     * @param filename
     * @return
     */
    public static List<Integer> readNumbers(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] strNumbers = line.split(" ");

            List<Integer> res = new ArrayList<>();
            for (String strNumber : strNumbers) {
                res.add(Integer.valueOf(strNumber));
            }
            return res;
        }
    }
}
