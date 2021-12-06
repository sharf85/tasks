package de.telran.list;

public class AdvancedArrayList<T> implements CustomList<T> {
    private T[] source;

    public AdvancedArrayList(int initialSize) {
        source = (T[]) new Object[initialSize];
    }

    @Override
    public void set(int index, T value) {
        source[index] = value;
    }

    @Override
    public T get(int index) {
        return source[index];
    }

    @Override
    public int size() {
        return source.length;
    }

    @Override
    public void insert(int index, T elt) {
        T[] newSource = (T[]) new Object[source.length + 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        newSource[index] = elt;

        for (int i = index + 1; i < newSource.length; i++) {
            newSource[i] = source[i - 1];
        }

        source = newSource;
    }

    @Override
    public boolean contains(T elt) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(elt))
                return true;
        }

        return false;
    }

    @Override
    public void removeById(int index) {
        T[] newSource = (T[]) new Object[source.length - 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }

        for (int i = index + 1; i < source.length; i++) {
            newSource[i - 1] = source[i];
        }

        source = newSource;
    }

    @Override
    public void add(T value) {
        insert(source.length, value);
    }

    @Override
    public void println() {
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }
}
