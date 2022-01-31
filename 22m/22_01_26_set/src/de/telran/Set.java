package de.telran;

public interface Set<T> extends Iterable<T>{

    /**
     * @param elt
     * @return whether the element did not exist int the set
     */
    boolean add(T elt);

    /**
     * @param elt
     * @return true if the elt was removed
     */
    boolean remove(T elt);

    boolean contains(T elt);

    int size();

    void addAll(Set<T> another);

    void removeAll(Set<T> another);

    void retainAll(Set<T> another);
}
