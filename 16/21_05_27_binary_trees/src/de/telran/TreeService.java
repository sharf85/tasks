package de.telran;

public class TreeService {

    //TODO complete
    /**
     * the method must return the distance to the most remote leaf from the root of the tree
     *
     * @param root
     * @return
     */
    public int getHeight(Vertex root) {
        return 0;
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
}
