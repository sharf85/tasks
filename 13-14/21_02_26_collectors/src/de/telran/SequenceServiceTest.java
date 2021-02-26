package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SequenceServiceTest {

    SequenceService sequenceService = new SequenceService();

    @Test
    public void testSumSquared_0() {
        assertEquals(0, sequenceService.sumSquared(Arrays.asList(0)));
    }

    @Test
    public void testSumSquared_1() {
        assertEquals(1, sequenceService.sumSquared(Arrays.asList(1)));
    }

    @Test
    public void testSumSquared_range1_5() {
        assertEquals(55, sequenceService.sumSquared(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void testSumSquared_numbers2_4_6() {
        assertEquals(56,sequenceService.sumSquared(Arrays.asList(2, 4, 6)));
    }

    @Test
    public void testSumSquared_numbers0_10() {
        assertEquals(100, sequenceService.sumSquared(Arrays.asList(0, 10)));
    }

    @Test
    public void testMultiplicationSquared_0() {
        assertEquals(0, sequenceService.multiplicationSquared(Arrays.asList(0)));
    }

    @Test
    public void testMultiplicationSquared_1() {
        assertEquals(1, sequenceService.multiplicationSquared(Arrays.asList(1)));
    }

    @Test
    public void testMultiplicationSquared_numbers0_10() {
        assertEquals(0, sequenceService.multiplicationSquared(Arrays.asList(0, 10)));
    }

    @Test
    public void testMultiplicationSquared_range1_5() {
        assertEquals(14400, sequenceService.multiplicationSquared(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void testMultiplicationSquared_numbers5_10() {
        assertEquals(2500, sequenceService.multiplicationSquared(Arrays.asList(5, 10)));
    }
}
