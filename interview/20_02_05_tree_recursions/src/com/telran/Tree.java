package com.telran;

public class Tree {

    Node root;

    public int size() {
        return rSize(root);
    }

    private int rSize(Node currentRoot) {

        int res = 1;
        for (Node child : currentRoot.children) {
            res += rSize(child);
        }

        return res;
    }
}
