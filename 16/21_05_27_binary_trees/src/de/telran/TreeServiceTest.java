package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeServiceTest {

    TreeService treeService = new TreeService();

    @Test
    public void testCountVertices_generalCase() {
        Vertex v1 = new Vertex(null, null);
        Vertex v5 = new Vertex(null, null);
        Vertex v7 = new Vertex(null, null);
        Vertex v6 = new Vertex(v7, null);
        Vertex v4 = new Vertex(v5, v6);
        Vertex v2 = new Vertex(v1, null);
        Vertex root = new Vertex(v2, v4);//root

        assertEquals(7, treeService.countVertices(root));
    }

    @Test
    public void testCountVertices_() {
        Vertex root = new Vertex(null, null);//root

        assertEquals(1, treeService.countVertices(root));
    }
}
