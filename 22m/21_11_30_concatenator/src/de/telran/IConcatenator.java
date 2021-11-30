package de.telran;
//TODO Implement this interface 4 ways:
// 1. with String
// 2. with StringBuilder
// 3. with StringBuffer
// 4. using char array, whose length is the total length of all the strings in the String array.
// The implementation should create a char array of the total length, then one by one copy every string into this array.
// After that create a result string based on this array.

public interface IConcatenator {

    /**
     * The method concatenates all the elements from "strings"
     * @param strings a String array to concatenate
     * @return concatenated string
     */
    String concatenate(String[] strings);
}
