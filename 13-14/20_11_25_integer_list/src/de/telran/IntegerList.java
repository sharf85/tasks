package de.telran;

public interface IntegerList {

    /**
     * Adds the element to the 'this' instance
     * @param element - to add
     */
    void addLast(int element);

    /**
     *
     * @param index - index of the element to return. It must be in the range between 0 and (size-1).
     * @return returns the element by the index
     */
    int get(int index);

    /**
     * sets the value to the index place in the 'this' instance
     * @param index the place to set
     * @param value the value to set
     */
    void set(int index, int value);

    /**
     * removes the element by the index
     * @param index the index of the element to remove
     * @return the value of the removed element
     */
    int removeById(int index);

    /**
     *
     * @return the size of 'this'
     */
    int size();

    /**
     * makes 'this' empty
     */
    void clear();
}
