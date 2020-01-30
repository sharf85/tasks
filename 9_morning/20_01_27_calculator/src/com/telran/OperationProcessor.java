package com.telran;

import com.telran.calculator.ICalculator;
import com.telran.calculator.WrongOperandException;

import java.util.ArrayList;
import java.util.List;

public class OperationProcessor {

    static final String WRONG_INPUT_ERROR_MESSAGE = "Input line is incorrect";
    static final String WRONG_FIRST_NUMBER_ERROR_MESSAGE = "First number is incorrect";
    static final String WRONG_SECOND_NUMBER_ERROR_MESSAGE = "Second number is incorrect";
    static final String WRONG_OPERATION_ERROR_MESSAGE = "Operation is not supported";

    static final String DELIMITER = ",";

    private ICalculator calculator;

    public OperationProcessor(ICalculator calculator) {
        this.calculator = calculator;
    }


    public List<String> processStrings(List<String> lines) {
        List<String> res = new ArrayList<>();

        for (String line : lines) {
            res.add(processString(line));
        }

        return res;
    }

    protected String processString(String line) {
        String[] members = line.split(DELIMITER);

        if (members.length != 3) {
            return line + DELIMITER + WRONG_INPUT_ERROR_MESSAGE;
        }

        double num1;
        try {
            num1 = Double.parseDouble(members[0]);
        } catch (NumberFormatException e) {
            return line + DELIMITER + WRONG_FIRST_NUMBER_ERROR_MESSAGE;
        }

        double num2;
        try {
            num2 = Double.parseDouble(members[2]);
        } catch (NumberFormatException e) {
            return line + DELIMITER + WRONG_SECOND_NUMBER_ERROR_MESSAGE;
        }

        char operand = members[1].charAt(0);

        double result;
        try {
            result = calculator.calculate(num1, num2, operand);
        } catch (WrongOperandException e) {
            return line + DELIMITER + WRONG_OPERATION_ERROR_MESSAGE;
        }

        return line + DELIMITER + result;
    }
}
