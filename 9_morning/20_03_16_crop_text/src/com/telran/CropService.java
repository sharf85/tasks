package com.telran;

public class CropService {

    /**
     * crop the text so that it contains no more than k symbols. If the symbols
     * in the end do not compose a word, than remove them down to the prev word.
     *
     * @param text a String to crop
     * @param k    the text length limit
     * @return cropped text according to the rule
     */
    public String crop(String text, int k) {
        int length = text.length();

        // hello, 5
        if (k >= length)
            return text;

        // "hello world", 5 -> "hello, "
//        "hello world", 4 -> "hell,o"
        String res = text.substring(0, k + 1);
        int lastSpaceIndex = res.lastIndexOf(" ");
        res = lastSpaceIndex < 0 ? "" : res.substring(0, lastSpaceIndex);

        return res;
    }
}
