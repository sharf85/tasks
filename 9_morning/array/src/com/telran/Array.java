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
        this.source = ArrayUtils.insert(this.source, index, number);
    }

    public void removeById(int index) {
        int[] newSource = new int[this.source.length - 1];
        for (int i = 0; i < index; i++) {
            newSource[i] = this.source[i];
        }
        for (int i = index + 1; i < this.source.length; i++) {
            newSource[i - 1] = this.source[i];
        }
        this.source = newSource;//!!!
    }

    public boolean remove(int element) {
        for (int i = 0; i < this.source.length; i++) {
            if (this.source[i] == element) {
                this.removeById(i);
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Arrays.toString(this.source);
    }
}


