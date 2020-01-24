package com.telran.collection;

import java.util.ArrayList;
import java.util.List;

public class OurHashMap<E, T> implements OurMap<E, T> {

    private static final int CAPACITY = 10000;
    private List<Node<E, T>>[] source = new List[CAPACITY];
    private int size;

    private static class Node<E, T> {
        public Node(E key, T value) {
            this.key = key;
            this.value = value;
        }

        E key;
        T value;
    }

    @Override
    public void put(E key, T value) {
        int index = computeIndex(key);

        if (source[index] == null) {
            source[index] = new ArrayList<>();
            Node<E, T> newNode = new Node<>(key, value);
            source[index].add(newNode);
            size++;
        } else {
            boolean wasFound = false;

            for (Node<E, T> oldNode : source[index]) {
                if (key.equals(oldNode.key)) {
                    wasFound = true;
                    oldNode.value = value;
                }
            }

            if(!wasFound){
                Node<E, T> newNode = new Node<>(key, value);
                source[index].add(newNode);
                size++;
            }
        }
    }

    private int computeIndex(E key) {
        return Math.abs(key.hashCode() % CAPACITY);
    }

    @Override
    public T get(E key) {

        int index = computeIndex(key);
        
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
        return 0;
    }
}
