package de.telran;

public interface CustomIterator<T> {
    /**
     *
     * @return true if there is left something to iterate
     */
    boolean hasNext();

    /**
     * The method returns the current element of the collection, for which the iterator is intended. And after that
     * it "turns" to the next element. Meaning, the next invocation of the method will return the next element
     * @return
     */
    T next();
}
