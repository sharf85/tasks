package de.telran;

public class SequenceService {

    public boolean isSubsequence(String text, String pattern) {
        return isSubsequenceRecursive(text, pattern, text.length(), pattern.length());
    }

    private boolean isSubsequenceRecursive(String text, String pattern, int textLength, int patternLength) {
        if (patternLength == 0)
            return true;

        if (textLength < patternLength)
            return false;

        if (text.charAt(textLength - 1) == pattern.charAt(patternLength - 1))
            return isSubsequenceRecursive(text, pattern, textLength - 1, patternLength - 1);

        return isSubsequenceRecursive(text, pattern, textLength - 1, patternLength);
    }

//    public boolean isSubsequence(String text, String pattern) {
//        int textLength = text.length();
//        int patternLength = pattern.length();
//
//        while (patternLength > 0) {
//            if (textLength < patternLength)
//                return false;
//
//            if (text.charAt(textLength - 1) == pattern.charAt(patternLength - 1)) {
//                textLength--;
//                patternLength--;
//            } else {
//                textLength--;
//            }
//        }
//        return true;
//    }

    public int getLengthMaxSharedSequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] res = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + 1;
                } else {
                    res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
                }
            }
        }
        return res[m][n];
    }
}
