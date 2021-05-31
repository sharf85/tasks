package de.telran;

public class TreeService {

    /**
     * the method must return the distance to the most remote leaf from the root of the tree
     *
     * @param root
     * @return
     */
    public int getHeight(Vertex root) {
        if (root == null)
            return -1;

        int leftHeight = getHeight(root.leftChild);
        int rightHeight = getHeight(root.rightChild);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * the method must return the number of the vertices in the tree with the root in 'root'
     *
     * @param root the root of the tree
     * @return
     */
    public int countVertices(Vertex root) {
        if (root == null)
            return 0;

        return countVertices(root.leftChild) + 1 + countVertices(root.rightChild);
    }

    public int getWeight(Vertex root) {
        if (root == null)
            return 0;

        return getWeight(root.leftChild) + root.weight + getWeight(root.rightChild);
    }
}
