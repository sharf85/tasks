package com.telran;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class StreamMergeTest {

    StreamMerge merge = new StreamMerge();

    @Test
    public void testCombineStreams_() {
        IntStream stream1 = IntStream.of(1, 3, 5, 7, 9);
        IntStream stream2 = IntStream.of(2, 4, 6, 8, 10);
        int[] expected = {6, 9, 10};
        int[] actual = merge
                .merge(stream1, stream2)
                .toArray();

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void testCombine() {
        IntStream a = IntStream.range(1, 11);
        IntStream b = IntStream.range(11, 21);
        int[] expected = {6, 9, 10, 12, 15, 18, 20};
        int[] actual = merge.merge(a, b).sorted().toArray();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
