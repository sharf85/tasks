package com.telran;

public class Palindrome {
    public boolean isPalindrome(String input) {
        String str = input.toLowerCase();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i))
                return false;
        }

        return true;
    }

    public boolean isPalindrome2(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString().equalsIgnoreCase(input);
    }
}
