package com.telran.calculator;

public interface ICalculator {

    double calculate(double num1, double num2, char operand) throws OperationNotSupported;
}
