package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeServiceTest {
    Node node_7 = new Node(null, null);
    Node node_9 = new Node(null, null);
    Node node_8 = new Node(node_9, null);
    Node node_6 = new Node(node_7, node_8);
    Node node_5 = new Node(null, node_6);

    Node node_1 = new Node(null, null);
    Node node_3 = new Node(null, null);
    Node node_2 = new Node(node_1, node_3);
    Node node_4 = new Node(node_2, node_5);

    NodeService nodeService = new NodeService();

    @Test
    void getVertexNumber_Test_node_4() {
        assertEquals(9, nodeService.getVertexNumber(node_4));
    }

    @Test
    void getVertexNumber_Test_node_2() {
        assertEquals(3, nodeService.getVertexNumber(node_2));
    }

    @Test
    void getVertexNumber_Test_node_1() {
        assertEquals(1, nodeService.getVertexNumber(node_1));
    }

    @Test
    void getVertexNumber_Test_node_3() {
        assertEquals(1, nodeService.getVertexNumber(node_3));
    }

    @Test
    void getVertexNumber_Test_node_5() {
        assertEquals(5, nodeService.getVertexNumber(node_5));
    }

    @Test
    void getVertexNumber_Test_node_6() {
        assertEquals(4, nodeService.getVertexNumber(node_6));
    }

    @Test
    void getVertexNumber_Test_node_7() {
        assertEquals(1, nodeService.getVertexNumber(node_7));
    }

    @Test
    void getVertexNumber_Test_node_8() {
        assertEquals(2, nodeService.getVertexNumber(node_8));
    }

    @Test
    void getVertexNumber_Test_node_9() {
        assertEquals(1, nodeService.getVertexNumber(node_9));
    }

    @Test
    void height_Test_node_4() {
        assertEquals(4, nodeService.getHeight(node_4));
    }

    @Test
    void height_Test_node_2() {
        assertEquals(1, nodeService.getHeight(node_2));
    }

    @Test
    void height_Test_node_1() {
        assertEquals(0, nodeService.getHeight(node_1));
    }

    @Test
    void height_Test_node_3() {
        assertEquals(0, nodeService.getHeight(node_3));
    }

    @Test
    void height_Test_node_5() {
        assertEquals(3, nodeService.getHeight(node_5));
    }

    @Test
    void height_Test_node_6() {
        assertEquals(2, nodeService.getHeight(node_6));
    }

    @Test
    void height_Test_node_7() {
        assertEquals(0, nodeService.getHeight(node_7));
    }

    @Test
    void height_Test_node_8() {
        assertEquals(1, nodeService.getHeight(node_8));
    }

    @Test
    void height_Test_node_9() {
        assertEquals(0, nodeService.getHeight(node_9));
    }
}
