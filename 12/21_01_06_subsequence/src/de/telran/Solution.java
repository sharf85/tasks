package de.telran;

public class Solution {

    public boolean solve(String text, String pattern) {
        return recursiveIsSubsequence(text,
                pattern,
                text.length() - 1,
                pattern.length() - 1);
    }

    private boolean recursiveIsSubsequence(String text,
                                           String pattern,
                                           int lastTextId,
                                           int lastPatternId) {
        if (lastPatternId < 0)
            return true;

        if (lastPatternId > lastTextId)
            return false;

        char textChar = text.charAt(lastTextId);
        char patternChar = pattern.charAt(lastPatternId);

        if (textChar == patternChar) {
            return recursiveIsSubsequence(text, pattern, lastTextId - 1, lastPatternId - 1);
        } else {
            return recursiveIsSubsequence(text, pattern, lastTextId - 1, lastPatternId);
        }
    }
}
