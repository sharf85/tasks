package com.telran;

public class BinaryTree {

    BinaryNode root;

    public int size() {
        return rSize(root);
    }

//    private int rSize(BinaryNode currentRoot) {
//        if (currentRoot.left == null && currentRoot.right == null)
//            return 1;
//
//        if (currentRoot.left == null)
//            return 1 + rSize(currentRoot.right);
//
//        if (currentRoot.right == null)
//            return 1 + rSize(currentRoot.left);
//
//        return 1 + rSize(currentRoot.left) + rSize(currentRoot.right);
//
//    }

    private int rSize(BinaryNode currentRoot) {
        if (currentRoot == null)
            return 0;

        return 1 + rSize(currentRoot.left) + rSize(currentRoot.right);
    }

    public int height() {
        return rHeight(root);
    }

    private int rHeight(BinaryNode currentRoot) {
        if (currentRoot == null)
            return 0;

        int heightLeft = rHeight(currentRoot.left);
        int heightRight = rHeight(currentRoot.right);

        return Math.max(heightLeft, heightRight) + 1;
    }
}
