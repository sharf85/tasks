package com.telran.collection;

import java.util.ArrayList;
import java.util.List;

public class OurHashMap<E, T> implements OurMap<E, T> {

    private static int CAPACITY = 10000;
    List<Node<E, T>>[] source = new ArrayList[10000];
    int size;

    @Override
    public void put(E key, T value) {
        int index = Math.abs(key.hashCode() % CAPACITY);
        if (source[index] == null) {
            List<Node<E, T>> list = new ArrayList<>();
            Node<E, T> newNode = new Node<>(key, value);
            list.add(newNode);
            source[index] = list;
            size++;
        } else {

            boolean wasFound = false;
            for (Node node : source[index]) {
                if (key.equals(node.key)) {
                    wasFound = true;
                    node.value = value;
                    break;
                }
            }

            if (!wasFound) {
                Node<E, T> newNode = new Node<>(key, value);
                source[index].add(newNode);
                size++;
            }

        }
    }

    @Override
    public T get(E key) {
        Node<E, T> node = findNode(key);
        return node != null ? node.value : null;
    }

    @Override
    public boolean contains(E key) {
        Node<E, T> node = findNode(key);
        return node != null;
    }

    private Node<E, T> findNode(E key) {
        int index = Math.abs(key.hashCode() % CAPACITY);

        if (source[index] != null) {
            for (Node<E, T> node : source[index]) {
                if (key.equals(node.key)) {
                    return node;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(E key) {
        Node<E, T> node = findNode(key);
        if (node == null)
            return false;

        int index = Math.abs(key.hashCode() % CAPACITY);
        source[index].remove(node);
        node.value = null;
        node.key = null;
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E, T> {
        public Node(E key, T value) {
            this.key = key;
            this.value = value;
        }

        E key;
        T value;
    }
}
