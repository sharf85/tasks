package de.telran.list;

//TODO complete (everything is in the AdvancedArray)
public class AdvancedArrayList implements CustomList {

    private int[] source;

    public AdvancedArrayList() {
        source = new int[0];
    }

    public AdvancedArrayList(int initialSize) {
        source = new int[initialSize];
    }

    @Override
    public void set(int index, int value) {

    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public void removeById(int index) {

    }

    @Override
    public void add(int value) {

    }

    @Override
    public void insert(int index, int value) {

    }

    @Override
    public void println() {

    }
}
