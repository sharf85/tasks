package com.telran;

public class Subsequence {
    public boolean isSubsequence(String pattern, String text) {
        return isSubsequenceRecursive(pattern, text, pattern.length(), text.length());
    }

    private boolean isSubsequenceRecursive(String pattern, String text, int patternLength, int textLength) {
        if (patternLength == 0)
            return true;

        if (textLength < patternLength)
            return false;

        if (pattern.charAt(patternLength - 1) == text.charAt(textLength - 1)) {
            return isSubsequenceRecursive(pattern, text, patternLength - 1, textLength - 1);
        } else {
            return isSubsequenceRecursive(pattern, text, patternLength, textLength - 1);
        }
    }
}
