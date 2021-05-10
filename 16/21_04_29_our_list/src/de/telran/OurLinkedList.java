package de.telran;

import java.util.Comparator;
import java.util.Iterator;


public class OurLinkedList<E> implements OurList<E> {

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    Node<E> first;
    Node<E> last;
    int size;

    @Override
    public E get(int index) {
        Node<E> needle = getNodeByIndex(index);
        return needle.element;
    }

    @Override
    public void set(int index, E elt) {
        Node<E> needle = getNodeByIndex(index);
        needle.element = elt;
    }

    private Node<E> getNodeByIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<E> currentNode = first;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public void add(E elt) {
        Node<E> newNode = new Node<>(elt, last, null);
//        if(first == null)
//        if(last == null)
        if (size == 0) {
            last = newNode;
            first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> toRemove = getNodeByIndex(index);
        E res = toRemove.element;
        removeNode(toRemove);
        return res;
    }

    @Override
    public boolean remove(E elt) {
        Node<E> toRemove = findNodeByElt(elt);
        if (toRemove == null)
            return false;

        removeNode(toRemove);
        return true;
    }

    private void removeNode(Node<E> toRemove) {
        Node<E> prev = toRemove.prev;
        Node<E> next = toRemove.next;

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        toRemove.element = null;
        toRemove.next = null;
        toRemove.prev = null;

        size--;
    }

    @Override
    public boolean contains(E elt) {
        Node<E> needle = findNodeByElt(elt);
        return needle != null;
    }

    /**
     * The method finds a node with the element inside equal to the 'elt'
     *
     * @param elt
     * @return the node with the element inside equal to the 'elt', if exists, or null
     */
    private Node<E> findNodeByElt(E elt) {
        Node<E> currentNode = first;
        if (elt == null) {
            while (currentNode != null) {
                if (currentNode.element == null)
                    return currentNode;
                currentNode = currentNode.next;
            }
        } else {
            while (currentNode != null) {
                if (elt.equals(currentNode.element))
                    return currentNode;
                currentNode = currentNode.next;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }


    // TODO complete the methods below
    @Override
    public void sort(Comparator<E> comparator) {

    }

    @Override
    public E max(Comparator<E> comparator) {
        return null;
    }

    @Override
    public E min(Comparator<E> comparator) {
        return null;
    }

    @Override
    public Iterator<E> backwardIterator() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
