package de.telran;

import java.util.*;

public class OurTreeMap<K, V> implements OurMap<K, V> {

    private static class Node<K, V> {
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        K key;
        V value;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    private final Comparator<K> keyComparator;
    private Node<K, V> root;
    private int size;

    public OurTreeMap(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
    }

    /**
     * if we use this constructor in the client code, that means that the keys are Comparable
     */
    public OurTreeMap() {
        this.keyComparator = new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                Comparable<K> comparableO1 = (Comparable<K>) o1;
                return comparableO1.compareTo(o2);
            }
        };
    }

    @Override
    public V put(K key, V value) {
        if (key == null)
            throw new NullPointerException();

        Node<K, V> current = root;
        Node<K, V> parent = null;
        int compared = 0;

        while (current != null) {
            parent = current;
            compared = keyComparator.compare(key, current.key);

            if (compared > 0)
                current = current.right;
            else if (compared < 0)
                current = current.left;
            else {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
        }

        Node<K, V> newNode = new Node<>(key, value, parent);
        if (compared > 0) {
            parent.right = newNode;
        } else if (compared < 0) {
            parent.left = newNode;
        } else {
            root = newNode;
        }

        size++;
        return null;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = findNode(key);
        return node == null ? null : node.value;
    }

    private Node<K, V> findNode(K key) {
        Node<K, V> current = root;

        while (current != null) {
            int compared = keyComparator.compare(key, current.key);

            if (compared > 0)
                current = current.right;
            else if (compared < 0)
                current = current.left;
            else {
                return current;
            }
        }
        return null;
    }


    @Override
    public V remove(K key) {
        Node<K, V> nodeToRemove = findNode(key);
        if (nodeToRemove == null)
            return null;

        size--;

        if (nodeToRemove.left != null && nodeToRemove.right != null)
            return junctionRemove(nodeToRemove);

        return linearRemove(nodeToRemove);
    }

    private V linearRemove(Node<K, V> nodeToRemove) {
        return null;
    }

    private V junctionRemove(Node<K, V> nodeToRemove) {
        Node<K, V> nextNode = findNext(nodeToRemove);

        V oldValue = nodeToRemove.value;
        nodeToRemove.key = nextNode.key;
        nodeToRemove.value = nextNode.value;

        linearRemove(nextNode);
        return oldValue;
    }

    private Node<K, V> findNext(Node<K, V> nodeToRemove) {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> keyIterator() {
        return null;
    }

    @Override
    public Iterator<V> valueIterator() {
        return null;
    }
}
