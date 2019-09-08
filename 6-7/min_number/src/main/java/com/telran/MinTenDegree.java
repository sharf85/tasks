package com.telran;

public class MinTenDegree {

    public int getTenDegree(int n) {
        String nString = Integer.toString(n);

        int length = nString.length();

        if (length == 1)
            return 0;

        return (int) Math.pow(10, length - 1);

    }
}
