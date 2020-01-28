package com.telran;

import com.telran.calculator.ICalculator;
import com.telran.calculator.WrongOperandException;

import java.util.ArrayList;
import java.util.List;

public class OperationProcessor {

    private ICalculator calculator;

    public OperationProcessor(ICalculator calculator) {
        this.calculator = calculator;
    }

    private static final String DELIMITER = ",";

    public List<String> processStrings(List<String> lines) {

        List<String> res = new ArrayList<>();

        for (String line : lines) {
            res.add(processString(line));
        }

        return res;
    }

    protected String processString(String line) {
        String[] members = line.split(DELIMITER);

        //TODO: compose the output line in the case of wrong input line protocol

        double num1 = Double.parseDouble(members[0]);
        double num2 = Double.parseDouble(members[2]);

        char operand = members[1].charAt(0);

        // TODO: handle exception here.
        double result = 0;
        try {
            result = calculator.calculate(num1, num2, operand);
        } catch (WrongOperandException e) {
            //TODO: compose correct output line
            //return ...;
        }

        return line + DELIMITER + result;
    }
}
