package com.telran.calculator;

public class BadCalculator implements ICalculator {
    @Override
    public double calculate(double num1, double num2, char operand) throws OperationNotSupportedException {
        switch (operand) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
        }
        OperationNotSupportedException ex = new OperationNotSupportedException();
        throw ex;
    }
}
