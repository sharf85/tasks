package com.telran;

public class SubsequenceFinder {

    public boolean isSubsequence(String pattern, String text) {
        return isSubsequenceRec(pattern, text, pattern.length(), text.length());
    }

    private boolean isSubsequenceRec(String pattern, String text, int patternLength, int textLength) {
        // if the current length of the text is smaller than the current length of the pattern,
        // therefore the pattern cannot be a subsequence of the text
        if (patternLength > textLength)
            return false;
        if (patternLength == 0)
            return true;

        if (pattern.charAt(patternLength - 1) == text.charAt(textLength - 1))
            return isSubsequenceRec(pattern, text, patternLength - 1, textLength - 1);

        return isSubsequenceRec(pattern, text, patternLength, textLength - 1);
    }
}
