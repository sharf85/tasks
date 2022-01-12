package de.telran;

public interface MaxStack {

    void add(int elt);

    int get();

    int remove();

    int size();

    //TODO
    // 1. Implement at least a simple implementation of the collection
    // 2. Try to implement this method so that it has the complexity O(1)
    // To simplify, one can use Java ready collections under the hood.
    int getMax();
}

