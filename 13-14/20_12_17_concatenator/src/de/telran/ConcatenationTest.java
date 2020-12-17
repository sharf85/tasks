package de.telran;

import java.util.Arrays;
import java.util.Collections;

public class ConcatenationTest {

    private final IConcatenator concatenator;

    public ConcatenationTest(IConcatenator concatenator) {
        this.concatenator = concatenator;
    }

    public void test(int times, String text) {
        String[] arrayToConcatenate = composeArray(times, text);

        long beforeTest = System.currentTimeMillis();
        concatenator.concatenate(arrayToConcatenate);
        long afterTest = System.currentTimeMillis();
        System.out.println(afterTest - beforeTest);
    }

    private String[] composeArray(int times, String text) {
        String[] strings = new String[times];
        Arrays.fill(strings, text);
        return strings;
    }
}
