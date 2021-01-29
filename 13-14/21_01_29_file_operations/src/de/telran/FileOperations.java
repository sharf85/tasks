package de.telran;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileOperations {

    /**
     * Writes the list of strings into the file, clearing it if the file exists and starts every string from new
     * line
     *
     * @param strings
     * @param filename
     */
    public void writeStrings(List<String> strings, String filename) {
    }

    /**
     * reads all the lines of the file into a list
     *
     * @param filename
     * @return list of lines
     */
    public List<String> readStrings(String filename) {
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
    public void writeInts(List<Integer> numbers, String filename) {

    }

    /**
     * The file contains data in the following format: "12 35 3534"
     *
     * @param filename
     * @return
     */

    // Integer.parseInt
    public List<Integer> readInts(String filename) {
    }
}
