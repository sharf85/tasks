package com.telran;

import com.telran.calculator.ICalculator;
import com.telran.calculator.WrongOperandException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OperationProcessorTest {

    ICalculator calculator;
    OperationProcessor op;

    @Before
    public void init() {
        calculator = mock(ICalculator.class);
        op = new OperationProcessor(calculator);
    }

    @Test
    public void testProcessString_legalLine_returnsMultiplication() throws WrongOperandException {
        String line = "2.5,*,2";
        when(calculator.calculate(2.5, 2, '*')).thenReturn(5.);

        String expected = line + ",5.0";
        assertEquals(expected, op.processString(line));
    }

    @Test
    public void testProcessString_legalLineWrongOperation_throwsWrongOperandException() throws WrongOperandException {
        String line = "2.5,*,2";
        when(calculator.calculate(2.5, 2, '*')).thenThrow(WrongOperandException.class);

        String expected = line + OperationProcessor.DELIMITER + OperationProcessor.WRONG_OPERATION_ERROR_MESSAGE;
        assertEquals(expected, op.processString(line));
    }

    @Test
    public void testProcessString_illegalLine_wrongFirstNumber() {
        String line = "asd,+,2";

        String expected = line + OperationProcessor.DELIMITER + OperationProcessor.WRONG_FIRST_NUMBER_ERROR_MESSAGE;
        assertEquals(expected, op.processString(line));

    }

    @Test
    public void testProcessStrings_oneLegalLineOneIllegalLine() throws WrongOperandException {
        String line1 = "asd,+,2";
        String line2 = "2.5,*,2";

        List<String> lines = Arrays.asList(line1, line2);
        when(calculator.calculate(2.5, 2, '*')).thenReturn(5.);

        List<String> result = op.processStrings(lines);
        List<String> expected = Arrays.asList(
                line1 + OperationProcessor.DELIMITER + OperationProcessor.WRONG_FIRST_NUMBER_ERROR_MESSAGE,
                line2 + ",5.0"
        );

        assertEquals(expected, result);
    }

}