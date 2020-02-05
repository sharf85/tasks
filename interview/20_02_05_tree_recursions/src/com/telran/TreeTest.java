package com.telran;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void testSize() {
        Node n7 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();

        n7.children = Arrays.asList(n5, n6);

        Tree tree = new Tree();
        tree.root = n7;

        assertEquals(3, tree.size());
    }
}