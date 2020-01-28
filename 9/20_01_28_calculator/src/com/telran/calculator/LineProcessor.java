package com.telran.calculator;

import java.util.ArrayList;
import java.util.List;

public class LineProcessor {

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
//        TODO: check that the members var is correct

        double num1 = Double.parseDouble(members[0]);
        double num2 = Double.parseDouble(members[2]);
        char operand = members[1].charAt(0);

//        TODO: handle the exception. Return line + delimiter + error text
        double res = 0;
        try {
            res = calculator.calculate(num1, num2, operand);
        } catch (OperationNotSupported operationNotSupported) {
        }
        return line + delimiter + res;
    }
}
