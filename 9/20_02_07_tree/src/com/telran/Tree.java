package com.telran;

public class Tree {

    TreeNode root;

    public int size() {
        return recursiveSize(root);
    }

    private int recursiveSize(TreeNode node) {
        if (node.left == null && node.right == null)
            return 1;

        if (node.left == null)
            return 1 + recursiveSize(node.right);

        if (node.right == null)
            return 1 + recursiveSize(node.left);

        return 1 + recursiveSize(node.left) + recursiveSize(node.right);
    }

    private int recursiveSizeOptimal(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + recursiveSizeOptimal(node.left) + recursiveSizeOptimal(node.right);
    }
}
