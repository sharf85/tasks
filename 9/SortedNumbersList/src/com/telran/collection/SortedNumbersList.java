package com.telran.collection;

import java.util.Arrays;

public class SortedNumbersList {

    private int[] source;

    public SortedNumbersList() {
        source = new int[0];
    }

    public SortedNumbersList(int[] array) {
        source = ArrayUtils.copyArray(array);

        ArrayUtils.selectionSort(source);
    }

    public void display() {
        System.out.println(Arrays.toString(source));
    }

    public void add(int number) {
        source = ArrayUtils.append(source, number);
        ArrayUtils.selectionSort(source);
    }

    public int get(int index) {
        return source[index];
    }

    public int size() {
        return source.length;
    }

    public boolean remove(int number) {
        int index = ArrayUtils.binarySearch(this.source, number);
        if (index < 0)
            return false;

        int[] newSource = new int[this.source.length - 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = this.source[i];
        }

        for (int i = index + 1; i < source.length; i++) {
            newSource[i - 1] = source[i];
        }

        this.source = newSource;
        return true;
    }

    public void removeById(int index) {

    }

    public void removeRepeated() {

    }

    /**
     * the method returns a new object of {@link SortedNumbersList} which is an intersection
     * of this and another
     *
     * @param another
     * @return
     */
    public SortedNumbersList intersection(SortedNumbersList another) {
        return null;
    }

    public SortedNumbersList union(SortedNumbersList another) {
        return null;
    }

    public boolean contains(int number) {
        return ArrayUtils.binarySearch(this.source, number) >= 0;
    }

}
