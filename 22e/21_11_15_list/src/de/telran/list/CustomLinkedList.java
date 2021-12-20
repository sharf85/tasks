package de.telran.list;

import de.telran.CustomOutOfBoundsException;

import java.util.Iterator;

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
        Node<T> node = getNodeByIndex(index);
        node.value = value;
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
        Node<T> node = findNodeByValue(value);
        return node != null;
    }

    @Override
    public T removeById(int index) {
        Node<T> nodeToRemove = getNodeByIndex(index);
        T res = nodeToRemove.value;
        removeNode(nodeToRemove);
        return res;
    }

    @Override
    public boolean removeByValue(T value) {
        Node<T> nodeToRemove = findNodeByValue(value);
        if (nodeToRemove == null)
            return false;

        removeNode(nodeToRemove);
        return true;
    }

    private void removeNode(Node<T> node) {
        Node<T> left = node.prev;
        Node<T> right = node.next;

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

        node.prev = null;
        node.next = null;
        node.value = null;

        size--;
    }

    /**
     * @param value
     * @return the first node with value or null if there is no such a node
     */
    // {10, 7, 10, 15}
    private Node<T> findNodeByValue(T value) {
        Node<T> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.value.equals(value)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }

        return null;
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
        Node<T> left;
        Node<T> right;

        if (size == index) {
            left = last;
            right = null;
        } else {
            right = getNodeByIndex(index);
            left = right.prev;
        }

        Node<T> node = new Node<>(value, right, left);
        if (left != null)
            left.next = node;
        else
            first = node;

        if (right != null)
            right.prev = node;
        else
            last = node;

        size++;
    }

    @Override
    public void println() {

    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(first);
    }

    private static class ListIterator<E> implements Iterator<E> {

        Node<E> current;

        public ListIterator(Node<E> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E res = current.value;
            current = current.next;
            return res;
        }
    }
}
