package de.telran;

// TODO implement this
public class OurArrayList<E> implements OurList<E> {

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Object[] source;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(E element) {
        if (size == source.length)
            increaseCapacity();

        source[size] = element;
        size++;
    }

    // O(n), where n is size
    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    @Override
    public E get(int index) {
        return null;
    }


    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E elt) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void set(int index, E elt) {

    }

    @Override
    public boolean contains(E elt) {
        return false;
    }
}
