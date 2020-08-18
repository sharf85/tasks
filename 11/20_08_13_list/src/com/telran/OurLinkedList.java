package com.telran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class OurLinkedList<T> implements OurList<T> {

    private int size;
    Node<T> first;
    Node<T> last;

    @Override
    public void add(T elt) {
        Node<T> newNode = new Node<>(elt, null, last);

        if (size == 0) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T elt) {
        Node<T> node = getNodeByIndex(index);
        node.elt = elt;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T get(int index) {
        Node<T> node = getNodeByIndex(index);
        return node.elt;
    }

    @Override
    public boolean contains(T elt) {
        return findNode(elt) != null;
    }

    /**
     * The method returns the node corresponding to the elt.
     *
     * @param elt to find the node
     * @return node if found or null otherwise
     */
    private Node<T> findNode(T elt) {
        Node<T> current = first;
        while (current != null) {
            if (elt.equals(current.elt))
                return current;
            current = current.next;
        }
        return null;
    }

    @Override
    public T remove(int index) {
        Node<T> nodeToRemove = getNodeByIndex(index);
        T res = nodeToRemove.elt;
        removeByNode(nodeToRemove);
        return res;
    }

    @Override
    public boolean remove(T elt) {
        Node<T> nodeToRemove = findNode(elt);
        if (nodeToRemove == null)
            return false;
        removeByNode(nodeToRemove);
        return true;
    }

    private void removeByNode(Node<T> toRemove) {
        Node<T> left = toRemove.prev;
        Node<T> right = toRemove.next;

        toRemove.prev = null;
        toRemove.next = null;
        toRemove.elt = null;

        if (size == 1) {
            first = last = null;
        } else if (first == toRemove) {
            right.prev = null;
            first = right;
        } else if (last == toRemove) {
            left.next = null;
            last = left;
        } else {
            right.prev = left;
            left.next = right;
        }

        size--;
    }

    @Override
    public void sort() {
        T[] array = toArray();
        Arrays.sort(array);
        updateThis(array);
    }

    private void updateThis(T[] array) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            current.elt = array[i];
            current = current.next;
        }
    }

    private T[] toArray() {
        Object[] res = new Object[size];

        Iterator<T> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            res[i++] = it.next();
        }
        return (T[]) res;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        T[] array = toArray();
        Arrays.sort(array, comparator);
        updateThis(array);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T res = current.elt;
                current = current.next;
                return res;
            }
        };
    }

    private static class Node<T> {

        public Node(T elt, Node<T> next, Node<T> prev) {
            this.elt = elt;
            this.next = next;
            this.prev = prev;
        }

        T elt;
        Node<T> next;
        Node<T> prev;
    }
}
