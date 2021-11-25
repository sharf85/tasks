package de.telran;

public class ConcatenationTester {

    /**
     * Tests performance of the given concatenator by adding the string toConcat number times.
     *
     * @param concatenator
     * @param toConcat
     * @param number
     * @return millis taken for the concatenation
     */
    public long test(IConcatenator concatenator, String toConcat, int number) {
        String[] strings = composeStrings(toConcat, number);

        long startTime = System.currentTimeMillis();
        concatenator.concat(strings);
        return System.currentTimeMillis() - startTime;
    }

    private String[] composeStrings(String toConcat, int number) {
        // TODO create an array of length number, each element of which is toConcat
    }


}
