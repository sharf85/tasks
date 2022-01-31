package de.telran;

public class Main {

    public static void main(String[] args) {

        Vertex v1 = new Vertex(null, null);
        Vertex v2 = new Vertex(null, null);
        Vertex v8 = new Vertex(v1, v2);
        Vertex v6 = new Vertex(null, null);
        Vertex v4 = new Vertex(null, null);
        Vertex v3 = new Vertex(v4, v8);
        Vertex v5 = new Vertex(v6, v3);

        VertexService vertexService = new VertexService();

        System.out.println(vertexService.countVertices(v5));
    }
}
