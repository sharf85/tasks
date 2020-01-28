package com.telran.calculator;

public class BadCalculator implements ICalculator {
    @Override
    public double calculate(double num1, double num2, char operand) throws OperationNotSupported {
        switch (operand) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
        }
        throw new OperationNotSupported();
    }
}
