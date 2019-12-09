package com.telran.collection;


public class OurLinkedList implements List {

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

        Node needle = first;
        for (int i = 0; i < index; i++) {
            needle = needle.next;
        }
        return needle.value;
    }

    @Override
    public void set(Object o, int index) {

    }

    @Override
    public Object removeById(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
