package com.telran.collection;


import com.telran.comparator.OurComparator;

public class OurLinkedList implements OurList {

    private Node first;
    private Node last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(Object value) {
        if (size > 0) {
            Node newNode = new Node(null, last, value);
            last.next = newNode;
            last = newNode;
        } else {
            Node newNode = new Node(null, null, value);
            first = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node needle = getNode(index);
        return needle.value;
    }

    @Override
    public void set(Object o, int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node needle = getNode(index);
        needle.value = o;
    }

    private Node getNode(int index) {
        Node needle = first;
        for (int i = 0; i < index; i++) {
            needle = needle.next;
        }

        return needle;
    }

    @Override
    public Object removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        if (size == 1) {
            Object value = first.value;
            first.value = null;
            first = null;
            last = null;
            size--;
            return value;
        }

        Node nodeToRemove = getNode(index);
        Node left = nodeToRemove.prev;
        Node right = nodeToRemove.next;
        Object value = nodeToRemove.value;

        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        nodeToRemove.value = null;

        if (index > 0 && index < size - 1) {
            left.next = right;
            right.prev = left;
        } else if (index == 0) {
            right.prev = null;
            first = right;
        } else {
            left.next = null;
            last = left;
        }
        size--;
        return value;
    }

    @Override
    public boolean remove(Object o) {
        Node current = first;

        for (int i = 0; i < size; i++) {
            if (o.equals(current.value)) {
                removeById(i);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node current = first;

        for (int i = 0; i < size; i++) {
            if (o.equals(current.value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Object max(OurComparator comparator) {
        return null;
    }

    @Override
    public Object min(OurComparator comparator) {
        return null;
    }

    @Override
    public void sort(OurComparator comparator) {

    }

    private static class Node {
        Node next;
        Node prev;
        Object value;

        public Node(Node next, Node prev, Object value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
