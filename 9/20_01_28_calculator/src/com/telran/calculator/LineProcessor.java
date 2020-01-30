package com.telran.calculator;

import java.util.ArrayList;
import java.util.List;

public class LineProcessor {

    static final String OPERATION_NOT_SUPPORTED_ERROR_MESSAGE = "Operation not supported";
    private static final String WRONG_FORMAT_ERROR_MESSAGE = "Wrong format";
    private static final String WRONG_FIRST_NUMBER_ERROR_MESSAGE = "First member is not number";
    private static final String WRONG_SECOND_NUMBER_ERROR_MESSAGE = "Second member is not number";
    private static final String DELIMITER = ",";

    private String delimiter = DELIMITER;
    private ICalculator calculator;

    public LineProcessor(ICalculator calculator) {
        this.calculator = calculator;
    }

    public LineProcessor(String delimiter, ICalculator calculator) {
        this.delimiter = delimiter;
        this.calculator = calculator;
    }

    public List<String> processLines(List<String> content) {
        List<String> res = new ArrayList<>();
        for (String line : content) {
            res.add(processLine(line));
        }
        return res;
    }

    String processLine(String line) {
        String[] members = line.split(delimiter);

        if (members.length != 3)
            return line + delimiter + WRONG_FORMAT_ERROR_MESSAGE;

        double num1;
        try {
            num1 = Double.parseDouble(members[0]);
        } catch (NumberFormatException e) {
            return line + delimiter + WRONG_FIRST_NUMBER_ERROR_MESSAGE;
        }

        double num2;
        try {
            num2 = Double.parseDouble(members[2]);
        } catch (NumberFormatException e) {
            return line + delimiter + WRONG_SECOND_NUMBER_ERROR_MESSAGE;
        }

        char operand = members[1].charAt(0);

        double res;
        try {
            res = calculator.calculate(num1, num2, operand);
        } catch (OperationNotSupportedException e) {
            return line + delimiter + OPERATION_NOT_SUPPORTED_ERROR_MESSAGE;
        }
        return line + delimiter + res;
    }
}
