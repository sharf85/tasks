package de.telran;

public class StringBuilderConcatenator implements IConcatenator {
    @Override
    public String concat(String[] strs) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }

        return sb.toString();
    }
}
