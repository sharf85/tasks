package com.telran;

public class CaseSwitcher {
    /**
     * @param line to change the case of the letter symbols
     * @return new string containing the letters with changed case
     */
    public String swap(String line) {
        char[] chars = line.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i]))
                chars[i] = Character.toLowerCase(chars[i]);
            else if (Character.isLowerCase(chars[i]))
                chars[i] = Character.toUpperCase(chars[i]);
        }

        return new String(chars);
    }
}
