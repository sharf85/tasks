package com.telran.collection;

import java.util.LinkedList;
import java.util.List;

public class OurHashMap<E, T> implements OurMap<E, T> {

    private static int CAPACITY = 10000;
    List<Node<E, T>>[] source;
    int size;

    @Override

    public void put(E key, T value) {
        int index = Math.abs(key.hashCode() % CAPACITY);
        if (source[index] == null) {
            List<Node<E, T>> list = new LinkedList<>();
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
        return null;
    }

    @Override
    public boolean contains(E key) {
        return false;
    }

    @Override
    public boolean remove(E key) {
        return false;
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
