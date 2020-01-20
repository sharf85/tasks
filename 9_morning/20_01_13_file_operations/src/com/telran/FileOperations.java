package com.telran;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

    public byte[] bytesFromFile(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);

        try {
            int length = fis.available();
            byte[] res = new byte[length];
            fis.read(res);
            return res;
        } finally {
            fis.close();
        }
    }

    public List<Integer> intsFromFile(String filename) throws IOException {
        byte[] bytes = bytesFromFile(filename);

        String str = new String(bytes);
        String[] parts = str.split(" ");

        List<Integer> list = new ArrayList<>();
        for (String part : parts) {
            list.add(Integer.valueOf(part));
        }
        return list;
    }

}
