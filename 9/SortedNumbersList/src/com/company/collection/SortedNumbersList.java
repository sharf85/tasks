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

    public boolean Remove(int number) {
        int index = ArrayUtils.binarySearch(source, number);

        if (index >= 0) {
            removeById(index);
            return true;
        }
        return false;
    }

    public void removeById(int index) {

        int[] result = new int[source.length - 1];

        for (int i = 0; i < index; i++) {
            result[i] = source[i];
        }
        for (int i = index + 1; i < source.length; i++) {
            result[i - 1] = source[i];
        }
        source = result;
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
        this.removeRepeated();
        another.removeRepeated();

        int newLength = 0;
        for (int i = 0; i < source.length; i++) {
            if (another.contains(source[i])) {
                newLength++;
            }
        }

        int[] newArray = new int[newLength];
        int counter = 0;
        for (int i = 0; i < source.length; i++) {
            if (another.contains(source[i]))
                newArray[counter++] = source[i];
        }

        SortedNumbersList result = new SortedNumbersList(newArray);
        result.removeRepeated();

        return result;
    }


    public SortedNumbersList union(SortedNumbersList another) {
        int arrayLenght = source.length + another.size();
        int[] newArray = new int[arrayLenght];

        for (int i = 0; i < source.length; i++) {
            newArray[i] = source[i];
        }
        for (int i = source.length, j = 0; i < arrayLenght; i++) {
            newArray[i] = another.source[j++];
        }

        SortedNumbersList result = new SortedNumbersList(newArray);
        result.removeRepeated();

        return result;
    }

    public boolean contains(int number) {
        return ArrayUtils.binarySearch(this.source, number) >= 0;
    }
}