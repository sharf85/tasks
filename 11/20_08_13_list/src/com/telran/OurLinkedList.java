package com.telran;

import java.util.Comparator;
import java.util.Iterator;

public class OurLinkedList<T> implements OurList<T> {

    private int size;
    Node<T> first;
    Node<T> last;

    @Override
    public void add(T elt) {
        Node<T> newNode = new Node<>(elt, null, last);

        if (size == 0) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T elt) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean contains(T elt) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T elt) {
        return false;
    }

    @Override
    public void sort() {

    }

    @Override
    public void sort(Comparator<T> comparator) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private static class Node<T> {

        public Node(T elt, Node<T> next, Node<T> prev) {
            this.elt = elt;
            this.next = next;
            this.prev = prev;
        }

        T elt;
        Node<T> next;
        Node<T> prev;
    }
}
