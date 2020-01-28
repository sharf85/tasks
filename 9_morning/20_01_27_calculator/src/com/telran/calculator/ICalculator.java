package com.telran.calculator;

public interface ICalculator {

    /**
     * @param num1    first number
     * @param num2    second number
     * @param operand operation to perform over the numbers
     * @return the result of the operation
     * @throws WrongOperandException in case if the operand is not supported
     */
    double calculate(double num1, double num2, char operand) throws WrongOperandException;
}
