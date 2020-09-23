package com.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphUtilsTest {

    ArrayList<List<Integer>> graph;
    GraphUtils utils = new GraphUtils();

    @BeforeEach
    public void init() {
        List<List<Integer>> temp = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(2, 3),
                Arrays.asList(1, 3),
                Arrays.asList(1, 2, 4),
                Arrays.asList(5, 3),
                Arrays.asList(4)
        );

        graph = new ArrayList<>(temp);
    }

    @Test
    public void testGetDistance_startAndFinishAreSingleVertex_0() {
        assertEquals(0, utils.getDistance(graph, 0, 0));
    }

    @Test
    public void testGetDistance_startAndFinishAreNonSingleSame_0() {
        assertEquals(0, utils.getDistance(graph, 3, 3));
        assertEquals(0, utils.getDistance(graph, 4, 4));
    }

    @Test
    public void testGetDistance_startSingleAndFinishNot__1() {
        assertEquals(-1, utils.getDistance(graph, 0, 3));
    }

    @Test
    public void testGetDistance_startAndFinishConnected_1() {
        assertEquals(1, utils.getDistance(graph, 1, 2));
        assertEquals(1, utils.getDistance(graph, 1, 3));
        assertEquals(1, utils.getDistance(graph, 3, 2));
    }

    @Test
    public void testGetDistance_startAndFinishConnected_2() {
        assertEquals(2, utils.getDistance(graph, 1, 4));
        assertEquals(2, utils.getDistance(graph, 2, 4));
        assertEquals(2, utils.getDistance(graph, 3, 5));

        assertEquals(2, utils.getDistance(graph, 4, 1));
        assertEquals(2, utils.getDistance(graph, 4, 2));
        assertEquals(2, utils.getDistance(graph, 5, 3));
    }

    @Test
    public void testGetDistance_startAndFinishConnected_3() {
        assertEquals(3, utils.getDistance(graph, 1, 5));
        assertEquals(3, utils.getDistance(graph, 2, 5));

        assertEquals(3, utils.getDistance(graph, 5, 1));
        assertEquals(3, utils.getDistance(graph, 5, 2));
    }
}
