package com.telran.collection;

import java.util.Comparator;
import java.util.Iterator;

public class OurTreeSet<E> extends OurAbstractSet<E> {

    TreeNode<E> root;
    private Comparator<E> comparator;
    private int size;

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
            root = new TreeNode<>();
            root.key = elt;
            size++;
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
        size++;
        return true;
    }

    @Override
    public boolean remove(E elt) {

        TreeNode<E> nodeToRemove = getNode(elt);

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
        } else if (parent.right == nodeToRemove) {
            parent.right = child;
        } else {
            parent.left = child;
        }

        if (child != null)
            child.parent = parent;

        clearNode(nodeToRemove);
    }

    private void clearNode(TreeNode<E> nodeToRemove) {
        nodeToRemove.key = null;
        nodeToRemove.left = null;
        nodeToRemove.right = null;
        nodeToRemove.parent = null;
    }

    @Override
    public boolean contains(E elt) {
        return (getNode(elt) != null);
    }

    private TreeNode<E> getNode(E elt) {
        TreeNode<E> current = root;

        while (current != null && comparator.compare(current.key, elt) != 0) {
            current = comparator.compare(elt, current.key) < 0 ? current.left : current.right;
        }
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new OurTreeSetIterator<>(this);
    }

    static class TreeNode<E> {
        TreeNode<E> parent;
        TreeNode<E> left;
        TreeNode<E> right;

        E key;
    }
}

class OurTreeSetIterator<E> implements Iterator<E> {

    private OurTreeSet<E> treeSet;
    private OurTreeSet.TreeNode<E> current;

    OurTreeSetIterator(OurTreeSet<E> treeSet) {
        this.treeSet = treeSet;
        this.current = treeSet.root == null ? null : getLeast(treeSet.root);
    }

    /**
     * finds the node with the least element of the collection
     *
     * @param current - the root of the tree to find the least. Must be non-zero
     * @return the node with the least element of the tree with root in current
     */
    private OurTreeSet.TreeNode<E> getLeast(OurTreeSet.TreeNode<E> current) {
        while (current.left != null)
            current = current.left;
        return current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        E res = current.key;

        if (current.right != null) {
            current = getLeast(current.right);
        } else {
            current = firstRightParent(current);
        }

        return res;
    }

    /**
     * the method finds the first parent which is to the right from current
     *
     * @param current element
     * @return next element by order if exists or null, if current is the most right elt in
     * the treeSet
     */
    private OurTreeSet.TreeNode<E> firstRightParent(OurTreeSet.TreeNode<E> current) {
//        OurTreeSet.TreeNode<E> parent = current.parent;
//        while (parent != null && parent.left != current) {
//            current = parent;
//            parent = parent.parent;
//        }

        while (current.parent != null && current.parent.left != current)
            current = current.parent;

        return current.parent;
    }
}
