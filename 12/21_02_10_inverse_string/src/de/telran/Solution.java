package de.telran;

public class Solution {

    public String solve(String input) {
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }

        return new String(chars);
    }
}
