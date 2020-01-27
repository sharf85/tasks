package com.telran.calculator;

public class SimpleCalculator implements ICalculator {
    @Override
    public double calculate(double num1, double num2, char operation) throws WrongOperandException {
        switch (operation) {
            case '+':
                return num1 + num2;

            case '-':
                return num1 - num2;
        }
        throw new WrongOperandException();
    }
}
