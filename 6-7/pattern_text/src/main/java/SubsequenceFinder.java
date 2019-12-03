public class SubsequenceFinder {

    public boolean isSubsequence(String text, String pattern) {
        return isSubsequence(text, pattern, text.length() - 1, pattern.length() - 1);
    }

    private boolean isSubsequence(String text, String pattern, int indexText, int indexPattern) {
        if (indexPattern < 0)
            return true;
        if (indexText < indexPattern)
            return false;

        if (text.charAt(indexText) == pattern.charAt(indexPattern))
            return isSubsequence(text, pattern, indexText - 1, indexPattern - 1);

        return isSubsequence(text, pattern, indexText - 1, indexPattern);
    }
}
