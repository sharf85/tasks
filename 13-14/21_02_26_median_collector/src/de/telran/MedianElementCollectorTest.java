package de.telran;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MedianElementCollectorTest {
    @Test
    public void testCollect_oddSizeStream() {
        Stream<Integer> numbers = Stream.of(5, 8, -10, 15, 7);

        Double res = numbers.collect(new MedianElementCollector());
        assertEquals(7, res, 0.00001);
    }

    @Test
    public void testCollect_evenSizeStream() {
        Stream<Integer> numbers = Stream.of(5, 8, -10, 15);

        Double res = numbers.collect(new MedianElementCollector());
        assertEquals(6.5, res, 0.00001);
    }
}
