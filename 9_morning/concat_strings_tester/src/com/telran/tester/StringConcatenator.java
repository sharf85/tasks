package com.telran.tester;

public class StringConcatenator implements ConcatenatorInterface {
    public String concatenate(String[] strings) {
        String res = "";
        for (int i = 0; i < strings.length; i++) {
            res += strings[i];
        }
        return res;
    }
}
