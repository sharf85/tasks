package de.telran;

// TODO implement other methods. Write tests
public class CustomArrayDeque<T> implements CustomDeque<T> {

    private T[] source;
    private int size = 0;
    private int firstElementIndex = 0;

    public CustomArrayDeque() {
        source = (T[]) new Object[8];
    }

    @Override
    public void addFirst(T elt) {
        if (size == source.length)
            increaseCapacity();

        firstElementIndex = firstElementIndex - 1;

        if (firstElementIndex == -1)
            firstElementIndex = source.length - 1;

        source[firstElementIndex] = elt;
        size++;
    }

    private void increaseCapacity() {
        T[] newSource = (T[]) new Object[source.length * 2];

        int j = 0;
        for (int i = firstElementIndex; i < source.length; i++) {
            newSource[j] = source[i];
            j++;
        }

        for (int i = 0; i < firstElementIndex; i++) {
            newSource[j] = source[i];
            j++;
        }

        firstElementIndex = 0;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public void addLast(T elt) {

    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
