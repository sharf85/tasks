package de.telran;

public interface OurList<E> {

    public E get(int index);

    public void add(E elt);

    public E remove(int index);

    public boolean remove(E elt);

    public int size();

    public void set(int index, E elt);

    public boolean contains(E elt);
}
