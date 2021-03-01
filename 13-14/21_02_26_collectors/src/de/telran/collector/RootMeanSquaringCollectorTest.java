package de.telran.collector;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RootMeanSquaringCollectorTest {
    RootMeanSquaringCollector ssc = new RootMeanSquaringCollector();

    @Test
    public void test_collect_case1() {
        Stream<Double> numbers = Stream.of(5.0, -3.0, 10.0);
        assertEquals(6.68331, numbers.collect(ssc), 0.00001);
    }

    @Test
    public void test_collect_case2() {
        Stream<Double> numbers = Stream.of(1.0, 0.0);
        assertEquals(0.70710678, numbers.collect(ssc), 0.00001);
    }
}
