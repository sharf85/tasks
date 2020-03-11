package com.telran;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GraphServiceTest {

    GraphService gs = new GraphService();

    @Test
    public void testBfs_severalVertices() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 5),
                Arrays.asList(4, 2, 0),
                Arrays.asList(1, 3, 5, 6),
                Arrays.asList(2, 4),
                Arrays.asList(1, 3),
                Arrays.asList(2, 6, 0),
                Arrays.asList(2, 5)
        );

        assertEquals(0, gs.getDistance(graph, 0, 0));
        assertEquals(1, gs.getDistance(graph, 0, 1));
        assertEquals(2, gs.getDistance(graph, 0, 2));
        assertEquals(3, gs.getDistance(graph, 0, 3));
        assertEquals(2, gs.getDistance(graph, 0, 4));
        assertEquals(1, gs.getDistance(graph, 0, 5));
        assertEquals(2, gs.getDistance(graph, 0, 6));
    }

}