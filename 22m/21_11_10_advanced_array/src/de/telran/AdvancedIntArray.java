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

    public boolean contains(int value) {
        for (int i = 0; i < source.length; i++) {
            if (value == source[i])
                return true;
        }
        return false;
    }

    public void delete(int index) {
        int[] newSource = new int[source.length - 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        for (int i = index; i < newSource.length; i++) {
            newSource[i] = source[i + 1];
        }

        source = newSource;
    }

    public void append(int value) {
        insert(source.length, value);
    }

    public void insert(int index, int value) {
        int[] newSource = new int[source.length + 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        newSource[index] = value;
        for (int i = index + 1; i < newSource.length; i++) {
            newSource[i] = source[i - 1];
        }

        source = newSource;
    }

    public void println() {
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }

}
