package com.telran;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Integer> ints = Arrays.asList(1, 2, 3);

        FileOperations fo = new FileOperations();
        fo.intsToFile(ints, "ints.txt");

        System.out.println(fo.intsFromFile("ints.txt"));

    }
}
