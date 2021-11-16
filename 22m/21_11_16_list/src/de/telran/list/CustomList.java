package de.telran.list;

/**
 * The interface describes the List data structure
 */
public interface CustomList {

    /**
     * The method swaps the value at the index position
     * @param index the position
     * @param value a new value for the index position
     */
    public void set(int index, int value);

    /**
     * The method gets the value on the index position
     * @param index the position, whose value to be returned
     * @return the value by its position
     */
    public int get(int index);

    /**
     *
     * @return The number of elements in the list
     */
    public int size();

    /**
     *
     * @param value to be found
     * @return whether the value is in the list
     */
    public boolean contains(int value);

    /**
     * removes the value by its position. The elements which are after the index move to the left by 1 position
     * @param index of the value to remove
     */
    public void removeById(int index);

    /**
     * Add an element to the end of the list
     * @param value to append
     */
    public void add(int value);

    /**
     * Inserts the value to the index place. All the elements which are after the index move to the right by 1 position
     * @param index the place to insert
     * @param value the element to insert
     */
    public void insert(int index, int value);

    /**
     * prints the element out to the console
     */
    public void println();

}
