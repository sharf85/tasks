package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeServiceTest {

    TreeService treeService = new TreeService();

    @Test
    public void testCountVertices_generalCase() {
        Vertex v1 = new Vertex(null, null, 0);
        Vertex v5 = new Vertex(null, null, 0);
        Vertex v7 = new Vertex(null, null, 0);
        Vertex v6 = new Vertex(v7, null, 0);
        Vertex v4 = new Vertex(v5, v6, 0);
        Vertex v2 = new Vertex(v1, null, 0);
        Vertex root = new Vertex(v2, v4, 0);//root

        assertEquals(7, treeService.countVertices(root));
    }

    @Test
    public void testCountVertices_leaf() {
        Vertex root = new Vertex(null, null, 0);//root

        assertEquals(1, treeService.countVertices(root));
    }

    @Test
    void countVertices() {
        Vertex v1 = new Vertex(null, null, 7);
        Vertex v5 = new Vertex(null, null, 6);
        Vertex v2 = new Vertex(v1, null, 15);
        Vertex v7 = new Vertex(null, null, 4);
        Vertex v6 = new Vertex(v7, null, 2);
        Vertex v4 = new Vertex(v5, v6, 1);
        Vertex root = new Vertex(v2, v4, 3); //root
        assertEquals(7, treeService.countVertices(root));

    }

    @Test
    void test_getHeight() {
        Vertex v1 = new Vertex(null, null, 7);
        Vertex v5 = new Vertex(null, null, 6);
        Vertex v2 = new Vertex(v1, null, 6);
        Vertex v7 = new Vertex(null, null, 4);
        Vertex v6 = new Vertex(v7, null, 2);
        Vertex v4 = new Vertex(v5, v6, 1);
        Vertex root = new Vertex(v2, v4, 3); //root
        assertEquals(3, treeService.getHeight(root));

    }

    @Test
    void test_getWeight() {
        Vertex v1 = new Vertex(null, null, 7);
        Vertex v5 = new Vertex(null, null, 6);
        Vertex v2 = new Vertex(v1, null, 6);
        Vertex v7 = new Vertex(null, null, 4);
        Vertex v6 = new Vertex(v7, null, 2);
        Vertex v4 = new Vertex(v5, v6, 1);
        Vertex root = new Vertex(v2, v4, 3); //root
        assertEquals(29, treeService.getWeight(root));

    }
}
