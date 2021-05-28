package de.telran;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Vertex v1 = new Vertex(null, null);
        Vertex v5 = new Vertex(null, null);
        Vertex v7 = new Vertex(null, null);
        Vertex v6 = new Vertex(v7, null);
        Vertex v4 = new Vertex(v5, v6);
        Vertex v2 = new Vertex(v1, null);

        Vertex v3 = new Vertex(v2, v4);//root

        TreeSet<Integer> set = new TreeSet<>();

    }
}
