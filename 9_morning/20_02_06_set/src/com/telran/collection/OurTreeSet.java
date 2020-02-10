package com.telran.collection;

import java.util.Comparator;
import java.util.Iterator;

public class OurTreeSet<E> implements OurSet<E> {

    private TreeNode<E> root;
    private Comparator<E> comparator;

    public OurTreeSet(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public OurTreeSet() {
        this.comparator = new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                Comparable<E> o1Comparable = (Comparable<E>) o1;

                return o1Comparable.compareTo(o2);
            }
        };
    }

    @Override
    public boolean add(E elt) {
        if (root == null) {
            root = new TreeNode();
            root.key = elt;
            return true;
        }

        TreeNode<E> parent = root;
        TreeNode<E> current = root;

        while (current != null && comparator.compare(current.key, elt) != 0) {
            parent = current;
            current = comparator.compare(elt, current.key) < 0 ? current.left : current.right;
        }

        if (current != null)
            return false;

        current = new TreeNode<>();
        current.key = elt;
        current.parent = parent;
        
        if (comparator.compare(elt, parent.key) < 0)
            parent.left = current;
        else
            parent.right = current;
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
        return 0;
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
        TreeNode<E> parent;
        TreeNode<E> left;
        TreeNode<E> right;

        E key;
    }
}
