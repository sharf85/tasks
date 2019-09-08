package com.telran.cycle_string;

public class CycleStringVerifier {

    public boolean isCycle(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int length = s1.length();

        if (length == 0)
            return true;

        for (int i = 0; i < length; i++) {
            if (s1.equals(shiftedString(s2, i)))
                return true;
        }

        return false;
    }

    private String shiftedString(String s2, int shift) {
        return s2.substring(shift) + s2.substring(0, shift);
    }
}
