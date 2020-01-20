package com.telran;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public void bytesToFile(byte[] bytes, String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        try {
            fos.write(bytes);
        } finally {
            fos.close();
        }
    }

    public byte[] fileToBytes(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            int length = fis.available();
            byte[] input = new byte[length];
            fis.read(input);
            return input;
        }
    }

    public void intListToFile(List<Integer> list, String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num);
            sb.append(" ");
        }
        byte[] output = sb.toString().getBytes();
        bytesToFile(output, filename);
    }

    public List<Integer> fileToIntList(String filename) throws IOException {
        String inputStr = new String(fileToBytes(filename));
        String[] parts = inputStr.split(" ");

        List<Integer> res = new ArrayList<>();
        for (String part : parts) {
            res.add(Integer.valueOf(part));
        }
        return res;
    }

}
