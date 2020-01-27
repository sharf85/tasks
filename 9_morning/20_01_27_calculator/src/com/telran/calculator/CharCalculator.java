package com.telran.calculator;

public class CharCalculator implements ICalculator {

    private static final String PATH_TO_OPERATIONS =
            "com.telran.calculator.char_operations.";

    @Override

    public double calculate(double num1, double num2, char operand) {
        String pathToClass = PATH_TO_OPERATIONS + getClassName(operand);//TODO: compose the path to the corresponding operation class
        Operation operation = (Operation) getClass().forName(pathToClass).newInstance();

        return operation.apply(num1, num2);
    }

    private String getClassName(char operand) {
        //TODO fill it
        return null;
    }
}
