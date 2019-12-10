package com.telran;

import java.util.Arrays;

public class StringPerformanceTester {

    private String forConcat;

    public StringPerformanceTester(String forConcat) {
        this.forConcat = forConcat;
    }

    public long perform(ConcatTextInterface concatenator, int nTexts) {
        String[] texts = createArray(nTexts);
        long now = System.currentTimeMillis();
        concatenator.concatenate(texts);
        return System.currentTimeMillis() - now;
    }

    private String[] createArray(int nTexts) {
        String[] res = new String[nTexts];
        Arrays.fill(res, forConcat);
        return res;
    }
}
