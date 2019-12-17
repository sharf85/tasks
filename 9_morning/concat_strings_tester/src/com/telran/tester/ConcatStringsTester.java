package com.telran.tester;

import java.util.Arrays;

public class ConcatStringsTester {

    private ConcatenatorInterface concatenator;

    public ConcatStringsTester(ConcatenatorInterface concatenator) {
        this.concatenator = concatenator;
    }

    public long test(int nStrings, String word) {
//        creates an array of length nString containing word in all cells
        String[] arrayToTest = makeArray(nStrings, word);

        long now = System.currentTimeMillis();
        concatenator.concatenate(arrayToTest);
        return System.currentTimeMillis() - now;
    }

    private String[] makeArray(int nStrings, String word) {
        String[] res = new String[nStrings];
        Arrays.fill(res, word);
        return res;
    }


}
