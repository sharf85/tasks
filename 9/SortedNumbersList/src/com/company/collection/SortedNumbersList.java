package com.company.collection;

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


    public void displayToString() {
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

    public boolean isRemove(int number) {
        if (ArrayUtils.booleanBinarySearch(source, number)) {
            source = ArrayUtils.remove(source, ArrayUtils.binarySearch(source, number));
            return true;
        }
        return false;
    }

    public void removeById(int index) {
        if (source.length > index)
            source = ArrayUtils.remove(source, index);
    }

    public void removeRepeated() {
        if (source.length == 0)
            return;
        source = ArrayUtils.removeRepeated(this.source);
    }

    public SortedNumbersList intersection(SortedNumbersList another) {
        return new SortedNumbersList(ArrayUtils.intersection(this.source, another.source));
    }

    public SortedNumbersList union(SortedNumbersList another) {
        return new SortedNumbersList(ArrayUtils.union(this.source, another.source));
    }

    public boolean isContains(int number) {
        return ArrayUtils.booleanBinarySearch(source, number);
    }
}