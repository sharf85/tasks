package de.telran;

public class AdvancedIntArray {

    private int[] source;

    public AdvancedIntArray(int initialSize) {
        source = new int[initialSize];
    }

    public int get(int index) {
        return source[index];
    }

    public void set(int index, int value) {
        source[index] = value;
    }

    public int size() {
        return source.length;
    }

    public void append(int value) {
        int[] newSource = new int[source.length + 1];

        for (int i = 0; i < source.length; i++) {
            newSource[i] = source[i];
        }

        newSource[newSource.length - 1] = value;
        source = newSource;
    }

    public void insert(int index, int value) {
        //TODO complete
    }

    public void delete(int index) {
        //TODO complete
    }

    public boolean contains(int value) {
        //TODO complete
    }
}
