package com.telran.collection;

public class OurLinkedList implements OurList {

    private int size;
    private Node first;
    private Node last;

    OurLinkedList() {
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

    private Node getNode(int index) {
        Node needle = first;
        for (int i = 0; i < index; i++) {
            needle = needle.next;
        }
        return needle;
    }

    @Override
    public void set(Object o, int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Node needle = getNode(index);
        needle.value = o;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node needle = first;
        for (int i = 0; i < size; i++) {
            if (needle.value.equals(o))
                return true;

            needle = needle.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node needle = first;
        for (int i = 0; i < size; i++) {
            if (needle.value.equals(o)) {
                removeById(i);
                return true;
            }

            needle = needle.next;
        }
        return false;
    }

    @Override
    public Object removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node nodeToRemove = getNode(index);
        Node left = nodeToRemove.prev;
        Node right = nodeToRemove.next;

        if (index > 0 && index < size - 1) {

            nodeToRemove.next = null;
            nodeToRemove.prev = null;

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
        return nodeToRemove.value;
    }

    private static class Node {
        Node() {

        }

        Node(Node next, Node prev, Object value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        Node next;
        Node prev;
        Object value;
    }
}
