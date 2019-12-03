package com.telran.collection;


public class SortedNumbersList {
    private int[] source;

    public SortedNumbersList() {
        this.source = new int[0];
    }

    public SortedNumbersList(int[] source) {
        this.source = ArrayUtils.copyArray(source);
        ArrayUtils.selectionSort(this.source);
    }

    public int size() {
        return source.length;
    }

    public boolean contains(int number) {
        int index = ArrayUtils.binarySearch(this.source, number);
        return index >= 0;
    }


    public void add(int number) {
        this.source = ArrayUtils.append(this.source, number);
        ArrayUtils.selectionSort(this.source);
    }

    public int get(int index) {
        return this.source[index];
    }

    /**
     * removes element with specified index
     *
     * @param index of the element to remove
     * @return removed element
     */
    public int removeById(int index) {
        int[] newSource = new int[this.source.length - 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = this.source[i];
        }
        for (int i = index + 1; i < this.source.length; i++) {
            newSource[i - 1] = this.source[i];
        }
        int res = this.source[index];

        this.source = newSource;
        return res;
    }

    public boolean remove(int number) {
        int index = ArrayUtils.binarySearch(this.source, number);
        if (index >= 0) {
            this.removeById(index);
            return true;
        }
        return false;
    }

    public void removeRepeated() {
        if (this.source.length == 0)
            return;

        int newSize = 1;
        for (int i = 1; i < this.source.length; i++) {
            if (this.source[i - 1] != this.source[i])
                newSize++;
        }

        int[] newSource = new int[newSize];
        newSource[0] = this.source[0];
        int currentIndex = 1;

        for (int i = 1; i < this.source.length; i++) {
            if (this.source[i - 1] != this.source[i]) {
                newSource[currentIndex++] = this.source[i];
            }
        }

        this.source = newSource;

    }

    public SortedNumbersList intersection(SortedNumbersList another) {
        int newSize = 0;

        for (int i = 0; i < source.length; i++) {
            if (another.contains(source[i]))
                newSize++;
        }

        int[] newSource = new int[newSize];
        int index = 0;
        for (int i = 0; i < source.length; i++) {
            if (another.contains(source[i]))
                newSource[index++] = source[i];
        }

        SortedNumbersList intersection = new SortedNumbersList(newSource);
        intersection.removeRepeated();
        return intersection;
    }

    public SortedNumbersList union(SortedNumbersList another) {
        int[] newSource = new int[this.source.length + another.source.length];

        for (int i = 0; i < this.source.length; i++) {
            newSource[i] = this.source[i];
        }

        for (int i = 0; i < another.source.length; i++) {
            newSource[i + source.length] = another.source[i];
        }

        SortedNumbersList newList = new SortedNumbersList(newSource);
        newList.removeRepeated();
        return newList;
    }
}
