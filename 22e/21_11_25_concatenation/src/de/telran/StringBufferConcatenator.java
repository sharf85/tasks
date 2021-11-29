package de.telran;

public class StringBufferConcatenator implements IConcatenator {
    @Override
    public String concat(String[] strs) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }

        return sb.toString();
    }
}
