package com.telran.collection;

import java.util.Iterator;

public class OurLinkedList<E> implements OurList<E>, Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(E value) {
        if (size > 0) {
            Node<E> newNode = new Node<>(null, last, value);
            last.next = newNode;
            last = newNode;
        } else {
            Node<E> newNode = new Node<>(null, null, value);
            first = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> needle = getNode(index);
        return needle.value;
    }

    @Override
    public void set(E o, int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> needle = getNode(index);
        needle.value = o;
    }

    private Node<E> getNode(int index) {
        Node<E> needle = first;
        for (int i = 0; i < index; i++) {
            needle = needle.next;
        }

        return needle;
    }

    @Override
    public E removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        if (size == 1) {
            E value = first.value;
            first.value = null;
            first = null;
            last = null;
            size--;
            return value;
        }

        Node<E> nodeToRemove = getNode(index);
        Node<E> left = nodeToRemove.prev;
        Node<E> right = nodeToRemove.next;
        E value = nodeToRemove.value;

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
    public E max(OurComparator comparator) {
        return null;
    }

    @Override
    public E min(OurComparator comparator) {
        return null;
    }

    @Override
    public void sort(OurComparator comparator) {

    }

    @Override
    public Iterator<E> iterator() {
        return new OurLinkedListIterator();
    }

    class OurLinkedListIterator implements Iterator<E> {

        Node<E> currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E res = currentNode.value;
            currentNode = currentNode.next;
            return res;
        }
    }

    private static class Node<E> {
        Node<E> next;
        Node<E> prev;
        E value;

        public Node(Node<E> next, Node<E> prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
