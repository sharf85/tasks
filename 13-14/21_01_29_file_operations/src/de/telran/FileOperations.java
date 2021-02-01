package de.telran;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FileOperations {

    /**
     * Writes the list of strings into the file, clearing it if the file exists and starts every string from new
     * line
     *
     * @param strings
     * @param filename
     */
    public void writeStrings(List<String> strings, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
//            for (String string : strings) {
//                fos.write(string.getBytes());
//                // different OS uses different line separator
//                fos.write(System.lineSeparator().getBytes());
//            }

            String output = String.join(System.lineSeparator(), strings);
            fos.write(output.getBytes());
        }
    }

    /**
     * reads all the lines of the file into a list
     *
     * @param filename
     * @return list of lines
     */
    public List<String> readStrings(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String input = new String(bytes);
            return Arrays.asList(input.split(System.lineSeparator()));
        }
    }

    public void writeBytes(byte[] bytes, String filename) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            outputStream.write(bytes);
        }
    }

    public byte[] readBytes(String filename) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return bytes;
        }
    }

    /**
     * Writes the list of number into the file with " " as a delimiter. [12, 35, 3534] -> "12 35 3534"
     *
     * @param numbers  to read into the file
     * @param filename
     */
    public void writeInts(List<Integer> numbers, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            if (numbers == null || numbers.size() == 0)
                return;

            StringBuilder sb = new StringBuilder();
            Iterator<Integer> iterator = numbers.iterator();

            sb.append(iterator.next());
            while (iterator.hasNext()) {
                sb.append("#").append(iterator.next());
            }

            fos.write(sb.toString().getBytes());
        }
    }

    /**
     * The file contains data in the following format: "12 35 3534"
     *
     * @param filename
     * @return
     */

    // Integer.parseInt
    public List<Integer> readInts(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String input = new String(bytes);

            String[] stringNumbers = input.split("#");
            List<Integer> res = new ArrayList<>();
            for (String stringNumber : stringNumbers) {
                res.add(Integer.parseInt(stringNumber));
            }
            return res;
        }
    }
}
