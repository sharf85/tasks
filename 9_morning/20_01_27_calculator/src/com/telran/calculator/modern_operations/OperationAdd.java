package com.telran.calculator.modern_operations;

import com.telran.calculator.ModernOperation;

public class OperationAdd implements ModernOperation {
    @Override
    public char getSymbol() {
        return '+';
    }

    @Override
    public double apply(double num1, double num2) {
        return num1 + num2;
    }
}
