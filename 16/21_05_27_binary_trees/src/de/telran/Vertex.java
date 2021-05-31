package de.telran;

public class Vertex {
    public Vertex leftChild;
    public Vertex rightChild;
    public int weight;

    public Vertex(Vertex leftChild, Vertex rightChild, int weight) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.weight = weight;
    }
}
