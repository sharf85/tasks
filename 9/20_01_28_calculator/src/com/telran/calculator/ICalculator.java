package com.telran.calculator;

public interface ICalculator {

    /**
     *
     * @param num1 first number
     * @param num2 second number
     * @param operand the action to perform over the two numbers
     * @return the result of the action performed
     * @throws OperationNotSupportedException if the operand is not supported
     */
    double calculate(double num1, double num2, char operand) throws OperationNotSupportedException;
}
