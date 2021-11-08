package de.telran;

public class AdvancedIntArray {

    private int[] source;

    public AdvancedIntArray(int initialSize) {
        source = new int[initialSize];
    }

    public void set(int index, int value) {
        source[index] = value;
    }

    public int get(int index) {
        return source[index];
    }

    public int size() {
        return source.length;
    }

    public void append(int elt) {
        int[] newSource = new int[source.length + 1];

        for (int i = 0; i < source.length; i++) {
            newSource[i] = source[i];
        }

        newSource[newSource.length - 1] = elt;

        source = newSource;
    }

    public void insert(int index, int elt) {
        //TODO
    }

    public void delete(int index) {
        //TODO
    }

    public void contains(int elt) {
        //TODO
    }

    public void println() {
        //TODO - print 'this' advanced array out into the console
    }
}
