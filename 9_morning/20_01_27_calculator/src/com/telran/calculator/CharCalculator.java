package com.telran.calculator;

import java.lang.reflect.InvocationTargetException;

public class CharCalculator implements ICalculator {

    private static final String PATH_TO_OPERATIONS =
            "com.telran.calculator.char_operations.";

    @Override
    public double calculate(double num1, double num2, char operand) throws WrongOperandException {
        String pathToClass = PATH_TO_OPERATIONS + getClassName(operand);
        try {
            Operation operation = (Operation) Class.forName(pathToClass).getConstructor().newInstance();
            return operation.apply(num1, num2);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            throw new WrongOperandException();
        }
    }

    String getClassName(char operand) {
        return "Operation_" + (int) operand;
    }
}
