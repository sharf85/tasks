package de.telran;

public class Vertex {
    public Vertex leftChild;
    public Vertex rightChild;

    public Vertex(Vertex leftChild, Vertex rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
