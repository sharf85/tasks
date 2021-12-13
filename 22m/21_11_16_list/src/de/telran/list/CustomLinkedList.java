package de.telran.list;

// TODO implement
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
            last = node;
        } else {
            last.next = node;
            last = node;
        }

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
        if (index < 0 || index > size)
            throw new CustomOutOfBoundsException();

        Node<T> currentNode = first;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public T removeById(int index) {
        return null;
    }

    @Override
    public boolean removeByValue(T value) {
        return false;
    }


    @Override
    public void insert(int index, T value) {

    }

    @Override
    public void println() {

    }
}

