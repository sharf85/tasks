package de.telran.list;

import java.util.Iterator;

public class CustomLinkedList<T> implements CustomList<T> {

    Node<T> first;
    Node<T> last;
    int size;

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
        }
    }

    @Override
    public void add(T value) {
        Node<T> node = new Node<>(value, last, null);

        if (size == 0) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;

        size++;
    }


    @Override
    public void set(int index, T value) {
        Node<T> node = getNodeByIndex(index);
        node.value = value;
    }

    @Override
    public T get(int index) {
        Node<T> node = getNodeByIndex(index);
        return node.value;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index < 0 || index >= size)
            throw new CustomOutOfBoundsException();

        Node<T> currentNode = first;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    @Override
    public boolean contains(T value) {
        Node<T> node = findNodeByValue(value);
        return node != null;
    }

    /**
     * The method finds the most left node containing the value
     *
     * @param value
     * @return node with the value or null, if no node contains the value
     */
    private Node<T> findNodeByValue(T value) {
        Node<T> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.value.equals(value))
                return currentNode;

            currentNode = currentNode.next;
        }
        return null;
    }


    @Override
    public T removeById(int index) {
        Node<T> toRemove = getNodeByIndex(index);
        T res = toRemove.value;
        removeNode(toRemove);
        return res;
    }

    @Override
    public boolean removeByValue(T value) {
        Node<T> toRemove = findNodeByValue(value);
        if (toRemove == null)
            return false;

        removeNode(toRemove);
        return true;
    }

    /**
     * The method removes the toRemove node from the linked list chain
     *
     * @param toRemove must be non-null
     */
    private void removeNode(Node<T> toRemove) {
        Node<T> left = toRemove.prev;
        Node<T> right = toRemove.next;

        if (left == null) {
            first = right;
        } else {
            left.next = right;
        }

        if (right == null) {
            last = left;
        } else {
            right.prev = left;
        }

        toRemove.next = null;
        toRemove.prev = null;
        toRemove.value = null;

        size--;
    }


    @Override
    public void insert(int index, T value) {
        Node<T> left;
        Node<T> right;

        if (index == size) {
            left = last;
            right = null;
        } else {
            right = getNodeByIndex(index);// throws exception if index < 0 or index >= size
            left = right.prev;
        }

        Node<T> toInsert = new Node<>(value, left, right);

        if (left == null) {
            first = toInsert;
        } else {
            left.next = toInsert;
        }

        if (right == null) {
            last = toInsert;
        } else {
            right.prev = toInsert;
        }

        size++;
    }

    @Override
    public void println() {

    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new BasicIterator<>(first);
        return iterator;
    }

    private static class BasicIterator<E> implements Iterator<E> {

        private Node<E> currentNode;

        public BasicIterator(Node<E> currentNode) {
            this.currentNode = currentNode;
        }

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

}

