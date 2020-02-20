package com.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public int height() {
        return rHeight(root);
    }

    private int rHeight(Node root) {
        int res = 1;

        int max = 0;

//        List<Integer> childrenHeights = new ArrayList<>();
//        for (Node node : root.children) {
//            childrenHeights.add(rHeight(node));
//        }
//
//        res += Collections.max(childrenHeights);

        for (Node node : root.children) {
            int currentHeight = rHeight(node);
            if (max < currentHeight)
                max = currentHeight;
        }
        res += max;

        return res;
    }

}
