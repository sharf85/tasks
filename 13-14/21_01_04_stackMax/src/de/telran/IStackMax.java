package de.telran;

public interface IStackMax<T> {
    public void addLast(T elt);

    public T getLast();

    public T removeLast();

    public int size();

    public T getMax();

}
