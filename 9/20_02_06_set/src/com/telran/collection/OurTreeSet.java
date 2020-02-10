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
        return false;
    }

    @Override
    public boolean contains(E elt) {
        return false;
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
        return null;
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
