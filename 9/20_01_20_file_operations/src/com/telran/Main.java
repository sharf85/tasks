package com.telran;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> ints = Arrays.asList(23, 34, -4, 8);

        FileOperations fo = new FileOperations();
        fo.intListToFile(ints, "file.txt");

        List<Integer> intsInput = fo.fileToIntList("file.txt");
        for (int num : intsInput) {
            System.out.print(num + " ");
        }

    }

}
