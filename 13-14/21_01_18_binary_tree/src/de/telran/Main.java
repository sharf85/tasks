package de.telran;

public class Main {

    public static void main(String[] args) {
        Node nine = new Node(null, null);
        Node seven = new Node(null, null);
        Node eight = new Node(nine, null);
        Node six = new Node(seven, eight);
        //...
    }
}

class Node {
    Node left;
    Node right;

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}
