package de.telran.list;

/**
 * The interface describes the List data structure
 */

//TODO
// Implement all the methods of AdvancedArrayList and CustomArrayList according to the contract (some methods
// must throw CustomOutOfBoundsException). See CustomList
public interface CustomList {

    /**
     * The method swaps the value at the index position
     *
     * @param index the position
     * @param value a new value for the index position
     * @throws CustomOutOfBoundsException if index is < 0 or index >= size
     */
    public void set(int index, int value);

    /**
     * The method gets the value on the index position
     *
     * @param index the position, whose value to be returned
     * @return the value by its position
     * @throws CustomOutOfBoundsException if index is < 0 or index >= size
     */
    public int get(int index);

    /**
     * @return The number of elements in the list
     */
    public int size();

    /**
     * @param value to be found
     * @return whether the value is in the list
     */
    public boolean contains(int value);

    /**
     * removes the value by its position. The elements which are after the index move to the left by 1 position
     *
     * @param index of the value to remove
     * @throws CustomOutOfBoundsException if index is < 0 or index >= size
     */
    public void removeById(int index);

    /**
     * Add an element to the end of the list
     *
     * @param value to append
     */
    public void add(int value);

    /**
     * Inserts the value to the index place. All the elements which are after the index move to the right by 1 position
     *
     * @param index the place to insert
     * @param value the element to insert
     * @throws CustomOutOfBoundsException if index is < 0 or index > size
     */
    public void insert(int index, int value);

    /**
     * prints the element out to the console
     */
    public void println();

}
