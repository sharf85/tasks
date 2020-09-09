package com.telran;

public class NodeService {
    public int getHeight(Node node) {
        if (node == null)
            return 0;

        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);
        return Math.max(leftH, rightH) + 1;
    }
}
