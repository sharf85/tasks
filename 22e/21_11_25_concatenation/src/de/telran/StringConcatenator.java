package de.telran;

public class StringConcatenator implements IConcatenator {
    @Override
    public String concat(String[] strs) {
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}
