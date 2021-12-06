package de.telran.list;

import de.telran.CustomOutOfBoundsException;

// TODO implement
public class CustomLinkedList<T> implements CustomList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        public Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void set(int index, T value) {
        // the same as get
    }

    @Override
    public T get(int index) {
        Node<T> node = getNodeByIndex(index);
        return node.value;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index < 0 || index >= size)
            throw new CustomOutOfBoundsException();

        Node<T> res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public void removeById(int index) {

    }

    @Override
    public void add(T value) {
        Node<T> node = new Node<>(value, null, last);

        if (size == 0) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
    }

    @Override
    public void insert(int index, T value) {

    }

    @Override
    public void println() {

    }
}
