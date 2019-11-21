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


    public void display() {
        System.out.println();
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
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

        int newLength = 1;

        for (int i = 1; i < source.length; i++) {
            if (source[i] != source[i - 1])
                newLength++;
        }

        int i = 1;
        int[] newSource = new int[newLength];

        newSource[0] = source[0];
        for (int j = 1; j < source.length; j++) {
            if (source[j] != source[j - 1])
                newSource[i++] = source[j];
        }
        source = newSource;
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