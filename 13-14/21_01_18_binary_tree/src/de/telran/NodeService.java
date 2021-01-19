package de.telran;

public class NodeService {

    public int getVertexNumber(Node root) {
        if (root == null)
            return 0;

        int leftSubtreeVertexNumber = getVertexNumber(root.getLeft());
        int rightSubtreeVertexNumber = getVertexNumber(root.getRight());

        return leftSubtreeVertexNumber + rightSubtreeVertexNumber + 1;
    }

    public int getHeight(Node root) {
        if (root == null)
            return -1;

        int leftSubtreeHeight = getHeight(root.getLeft());
        int rightSubtreeHeight = getHeight(root.getRight());

        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

}
