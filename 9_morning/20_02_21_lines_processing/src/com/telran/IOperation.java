package com.telran;

public interface IOperation {

    /**
     *
     * @return name of the operation
     */
    String getName();

    /**
     * Takes input string, process it and returns the result
     *
     * @param input string to process
     * @return result string
     */
    String operate(String input);
}
