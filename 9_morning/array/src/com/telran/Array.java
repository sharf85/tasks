package com.telran;

import java.util.Arrays;

public class Array {

    private int[] source;

    public Array() {
        this.source = new int[0];
    }

    public Array(int[] source) {
        this.source = ArrayUtils.copyArray(source);
    }

    // array[index] = value; - regular array
    // ourArray.set(index, value); - our implementation
    public void set(int index, int value) {
        this.source[index] = value;
    }

    // int a = array[index];
    // int a = ourArray.get(index);
    public int get(int index) {
        return this.source[index];
    }

    public int size() {
        return this.source.length;
    }

    /**
     * adds the value to the end of the current object
     *
     * @param value element to add
     */
    public void append(int value) {
        this.source = ArrayUtils.append(this.source, value);
    }

    public void insert(int index, int number) {

    }

    public void removeById(int index) {

    }

    public boolean remove(int element) {
        return false;
    }

    public String toString() {
        return Arrays.toString(this.source);
    }
}


