package com.telran.collection;

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
        return false;
    }

    public void removeById(int index) {

    }

    public void removeRepeated() {

    }

    /**
     * the method returns a new object of {@link SortedNumbersList} which is an intersection
     * of this and another
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
        return false;
    }

}
