package com.telran.tester;

import java.util.Arrays;

public class ConcatStringsTester {

    public long test(int nStrings, String word, ConcatenatorInterface concatenator) {
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
