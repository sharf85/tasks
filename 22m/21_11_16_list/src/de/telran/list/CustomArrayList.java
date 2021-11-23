package de.telran.list;

public class CustomArrayList implements CustomList {

    private static final int INITIAL_CAPACITY = 8;

    private int[] source;
    private int size;

    public CustomArrayList() {
        source = new int[INITIAL_CAPACITY];
    }

    @Override
    public void set(int index, int value) {
        source[index] = value;
    }

    @Override
    public int get(int index) {
        return source[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (source[i] == value)
                return true;
        }
        return false;
    }

    @Override
    public void removeById(int index) {
        for (int i = index + 1; i < size; i++) {
            source[i - 1] = source[i];
        }
        size--;
    }

    @Override
    public void add(int value) {
        if (size == source.length)
            increaseCapacity();

        source[size++] = value;
    }

    private void increaseCapacity() {
        int[] newSource = new int[source.length * 2];
        for (int i = 0; i < source.length; i++) {
            newSource[i] = source[i];
        }
        source = newSource;
    }

    @Override
    public void insert(int index, int value) {
        if (size == source.length)
            increaseCapacity();

        for (int i = size; i > index; i--) {
            source[i] = source[i - 1];
        }
        source[index] = value;
        size++;
    }

    @Override
    public void println() {
        for (int i = 0; i < size; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }
}
