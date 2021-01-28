package de.telran;

public interface OurSet<T> extends Iterable<T> {

    boolean add(T elt);

    boolean remove(T elt);

    boolean contains(T elt);

    int size();

    default void addAll(OurSet<T> another) {
        for (T elt : another) {
            add(elt);
        }
    }

    void retainAll(OurSet<T> another);

    default void removeAll(OurSet<T> another) {
        for (T elt : another) {
            remove(elt);
        }
    }

}
