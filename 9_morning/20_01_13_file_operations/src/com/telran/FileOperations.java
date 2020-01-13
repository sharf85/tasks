package com.telran;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileOperations {

    public void intsToFile(List<Integer> ints, String filename) throws IOException {

        StringBuilder builder = new StringBuilder();
        for (Integer current : ints) {
            builder.append(current);
            builder.append(" ");
        }

        bytesToFile(builder.toString().getBytes(), filename);
    }

    public void bytesToFile(byte[] bytes, String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename, true);
        try {
            fos.write(bytes);
        } finally {
            fos.close();
        }
    }


}
