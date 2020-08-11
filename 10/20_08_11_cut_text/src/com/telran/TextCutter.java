package com.telran;

public class TextCutter {
    public String cut(String text, int N) {
        if (N >= text.length())
            return text;

        String cutText = text.substring(0, N);
        if (text.charAt(N) == ' ')
            return cutText;

        int lastSpaceIndex = cutText.lastIndexOf(' ');
        return lastSpaceIndex == -1 ? "" : cutText.substring(0, lastSpaceIndex);
    }
}
