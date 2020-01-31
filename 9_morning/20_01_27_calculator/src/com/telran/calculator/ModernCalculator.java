package com.telran.calculator;

public class ModernCalculator implements ICalculator {

    OperationManager manager;

    public ModernCalculator(OperationManager manager) {
        this.manager = manager;
    }

    @Override
    public double calculate(double num1, double num2, char operand) throws WrongOperandException {
        Operation operation = manager.get(operand);
        if (operation == null)
            throw new WrongOperandException();

        return operation.apply(num1, num2);
    }
}
