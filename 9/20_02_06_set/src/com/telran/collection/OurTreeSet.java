package com.telran.collection;

import java.util.Comparator;
import java.util.Iterator;

public class OurTreeSet<E> implements OurSet<E> {

    private TreeNode<E> root;
    private int size;
    private Comparator<E> comparator;

    public OurTreeSet(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public OurTreeSet() {
        this.comparator = (o1, o2) -> {
            Comparable<E> o1comparable = (Comparable<E>) o1;
            return o1comparable.compareTo(o2);
        };
    }

    @Override
    public boolean add(E elt) {
        if (root == null) {
            root = new TreeNode<>(elt);
            size++;
            return true;
        }

        TreeNode<E> parent = root;
        TreeNode<E> current = root;

        while (current != null && comparator.compare(elt, current.key) != 0) {
            parent = current;
            current = comparator.compare(elt, current.key) < 0 ? current.left : current.right;
        }

        if (current != null)
            return false;

        TreeNode<E> newNode = new TreeNode<>(elt);
        newNode.parent = parent;
        if (comparator.compare(elt, parent.key) < 0)
            parent.left = newNode;
        else
            parent.right = newNode;

        size++;
        return true;
    }

    @Override
    public boolean remove(E elt) {
        TreeNode<E> nodeToRemove = findNode(elt);
        if (nodeToRemove == null)
            return false;

        if (nodeToRemove.left == null || nodeToRemove.right == null)
            linealRemove(nodeToRemove);
        else
            junctionRemove(nodeToRemove);

        size--;
        return true;
    }

    private void junctionRemove(TreeNode<E> nodeToRemove) {
        TreeNode<E> needle = nodeToRemove.right;

        while (needle.left != null)
            needle = needle.left;

        nodeToRemove.key = needle.key;
        linealRemove(needle);
    }

    private void linealRemove(TreeNode<E> nodeToRemove) {
        TreeNode<E> parent = nodeToRemove.parent;
        TreeNode<E> child = nodeToRemove.left == null ? nodeToRemove.right : nodeToRemove.left;

        if (parent == null) {
            root = child;
        } else if (parent.left == nodeToRemove) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        if (child != null)
            child.parent = parent;

        clearNode(nodeToRemove);
    }

    private void clearNode(TreeNode<E> nodeToRemove) {
        nodeToRemove.right = null;
        nodeToRemove.left = null;
        nodeToRemove.parent = null;
        nodeToRemove.key = null;
    }

    @Override
    public boolean contains(E elt) {
        return findNode(elt) != null;
    }

    private TreeNode<E> findNode(E elt) {
        TreeNode<E> current = root;

        while (current != null && comparator.compare(elt, current.key) != 0) {
            current = comparator.compare(elt, current.key) < 0 ? current.left : current.right;
        }

        return current;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addAll(OurSet<E> other) {
        return false;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {
        return false;
    }

    @Override
    public boolean retainAll(OurSet<E> other) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            TreeNode<E> current = getLeast(root);

            private TreeNode<E> getLeast(TreeNode<E> root) {
                TreeNode<E> needle = root;
//TODO complete
                return needle;
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E res = current.key;

                if (current.right != null)
                    current = getLeast(current.right);
                else
                    current = getRightParent(current);

                return res;
            }

            private TreeNode<E> getRightParent(TreeNode<E> current) {
                return null;
            }
        };
    }

    private static class TreeNode<E> {
        public TreeNode(E key) {
            this.key = key;
        }

        TreeNode<E> parent;
        TreeNode<E> left;
        TreeNode<E> right;
        E key;
    }
}
