package de.telran;

import java.util.Iterator;

public class OurLinkedList<T> implements OurList<T> {

    Node<T> first;// null
    Node<T> last;// null
    int size;// 0

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T element;

        public Node(Node<T> next, Node<T> prev, T element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }
    }


    @Override
    public void addLast(T element) {
        if (size == 0) {
            Node<T> node = new Node<>(null, null, element);
            first = last = node;
        } else {
            Node<T> node = new Node<>(null, last, element);
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void set(int index, T value) {
        Node<T> needle = getNodeByIndex(index);
        needle.element = value;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    @Override
    public T removeById(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean remove(T obj) {
        return false;
    }

    @Override
    public boolean contains(T obj) {
        return false;
    }

    @Override
    public Iterator<T> forwardIterator() {
        return null;
    }

    @Override
    public Iterator<T> backwardIterator() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

}
