package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class NodeServiceTest {

    NodeService service = new NodeService();

    Node three = new Node(null, null, 3);
    Node six = new Node(null, null, 6);
    Node eight = new Node(null, null, 8);
    Node nine = new Node(eight, null, 9);
    Node seven = new Node(six, nine, 7);
    Node five = new Node(three, seven, 5);

    @Test
    public void testHeight_5_4() {
        assertEquals(4, service.getHeight(five));
    }

    @Test
    public void testHeight_7_3() {
        assertEquals(3, service.getHeight(seven));
    }

    @Test
    public void testHeight_3_1() {
        assertEquals(1, service.getHeight(three));
    }

    @Test
    public void testHeight_6_1() {
        assertEquals(1, service.getHeight(six));
    }

    @Test
    public void testHeight_9_2() {
        assertEquals(2, service.getHeight(nine));
    }

    @Test
    public void testHeight_8_1() {
        assertEquals(1, service.getHeight(eight));
    }
}
