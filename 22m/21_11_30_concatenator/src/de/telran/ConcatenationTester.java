package de.telran;

import java.util.Arrays;

public class ConcatenationTester {

    /**
     * The method test the performance of concatenation using "concatenator", adding the "string" "number" times to itself
     *
     * @param concatenator - the way (implementation) to test performance with
     * @param string       to concatenate
     * @param number       times to concatenate
     * @return the time taken for the concatenation with "concatenator"
     */
    public long test(IConcatenator concatenator, String string, int number) {
        String[] strings = composeStrings(string, number);

        long currentTimeMillis = System.currentTimeMillis();
        concatenator.concatenate(strings);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    private String[] composeStrings(String string, int number) {
        String[] strings = new String[number];
        Arrays.fill(strings, string);
        return strings;
    }
}
